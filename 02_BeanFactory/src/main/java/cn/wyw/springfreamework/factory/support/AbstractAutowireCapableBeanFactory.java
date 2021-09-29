package cn.wyw.springfreamework.factory.support;

import cn.wyw.springfreamework.factory.BeanException;
import cn.wyw.springfreamework.factory.config.BeanDefinition;

/**
 * 抽象可以注入的bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 23:19
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeanException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException  | IllegalAccessException e) {
            throw new BeanException("InstantiationException exception", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
