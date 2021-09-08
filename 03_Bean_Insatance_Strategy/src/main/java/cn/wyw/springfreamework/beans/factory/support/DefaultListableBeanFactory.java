package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import cn.wyw.springfreamework.beans.factory.config.SingletonBeanRegister;

/**
 * 默认可展示 Bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/7 15:44
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister {

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        return null;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return null;
    }

    @Override
    public Object registerBean(String beanName, BeanDefinition beanDefinition) {
        return null;
    }
}
