package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.BeansException;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * 实现默认bean创建工厂的超类
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
