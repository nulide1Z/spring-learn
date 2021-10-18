package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.BeansException;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
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
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw  new BeansException("Instantiation of bean failure");
        }
        return bean;
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
