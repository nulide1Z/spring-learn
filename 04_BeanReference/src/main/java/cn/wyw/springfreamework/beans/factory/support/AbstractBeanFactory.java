package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.factory.BeanFactory;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;

/**
 * bean 工厂模板方法
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:46
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    protected Object doGetBean(final String beanName, Object[] args){
        Object singletonBean = getSingleton(beanName);
        if (null != singletonBean){
            return singletonBean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    /**
     * 获取BeanDefinition 模板方法
     *
     * @param beanName bean名称
     * @return beanDefinition
     * @author wangyuwen
     * @date 2021/9/29 - 16:48
     **/
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建bean 模板方法
     *
     * @param beanName bean 名称
     * @param beanDefinition bean 定义
     * @param args 参数
     * @return
     * @author wangyuwen
     * @date 2021/9/29 - 16:51
     **/
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);
}
