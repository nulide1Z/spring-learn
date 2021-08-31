package cn.wyw.springfreamework.factory.support;

import cn.wyw.springfreamework.factory.BeanFactory;
import cn.wyw.springfreamework.factory.config.BeanDefinition;

/**
 * bean 工厂抽象类
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 00:40
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {


    @Override
    public Object getBean(String name) {
        Object bean  =  getSingleton(name);
        if (bean != null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 根据名称获取bean 的定义
     *
     * @param beanName bean 名称
     * @return  bean 的定义
     * @author wangyuwen
     * @date 2021/9/1 - 0:23
     **/
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建bean
     *
     * @param beanName bean 名称
     * @param beanDefinition bean 定义
     * @return  bean对象
     * @author wangyuwen
     * @date 2021/9/1 - 0:23
     **/
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
