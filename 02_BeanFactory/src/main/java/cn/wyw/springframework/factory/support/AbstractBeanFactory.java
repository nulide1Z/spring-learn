package cn.wyw.springframework.factory.support;

import cn.wyw.springframework.factory.BeanFactory;
import cn.wyw.springframework.factory.config.BeanDefinition;

/**
 * bean 工厂抽象类
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 00:40
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {

    @Override
    public Object getBean(String name) {
        //  继承DefaultSingletonBeanRegister 根据名称在DefaultSingletonBeanRegister找到
        Object bean  =  super.getSingleton(name);
        if (bean != null){
            return bean;
        }
        // 从beanDefinition中找(DefaultListableBeanFactory 中实现) ,
        BeanDefinition beanDefinition = getBeanDefinition(name);
        //获取bean 的定义, 再通过添加单例 放入到 DefaultSingletonBeanRegister
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
