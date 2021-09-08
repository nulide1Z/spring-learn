package cn.wyw.springfreamework.beans.factory.support;

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

    protected  Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args){
        Object bean = null;

        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor ctor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length){
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
