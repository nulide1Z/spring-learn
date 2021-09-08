package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.factory.BeanFactory;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;

/**
 * 抽象bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:46
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {

    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public Object getBean(String name, Object... args) {
        return null;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
