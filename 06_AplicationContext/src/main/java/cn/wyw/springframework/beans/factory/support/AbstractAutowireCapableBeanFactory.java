package cn.wyw.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.PropertyValue;
import cn.wyw.springframework.beans.PropertyValues;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.beans.factory.config.BeanReference;
import java.lang.reflect.Constructor;

/**
 * 实现默认bean创建工厂的抽象类
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 16:26
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory  {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    private InstantiationStrategy jdkStrategy = new SimpleInstantiationStrategy();

    @Override
    protected  Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args){
        if (beanDefinition == null){
            throw new BeansException("had not yet register bean: "+beanName+" !");
        }
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            // apply property value
            this.applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw  new BeansException("Instantiation of bean failure");
        }
        return bean;
    }

    public  void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {

        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValue()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition,  Object[] args){
        Constructor ctor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            // 这里遍历出来的感觉不够严谨, 如果有同长度, 参数类型不一致的构造器, 就有问题了
            if (null != args && declaredConstructor.getParameterTypes().length == args.length){
                ctor = declaredConstructor;
                break;
            }
        }
       return getInstantiationStrategy().instantiate(beanDefinition, beanName, ctor, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
