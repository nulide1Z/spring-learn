package cn.wyw.springframework.beans.factory.config;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 此接口用来在对BeanDefinition 加载之后对Bean的一些操作, 可用于修改BeanDefinition的属性
 * 在spring 源码中只定义了一个接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/3 10:14
 */
public interface BeanFactoryPostProcessor {

    /**
     * 尚未实例化之间对BeanDefinition 做定制化处理
     *
     * @param configurableListableBeanFactory  大多数可列出bean工厂要实现的配置接口
     * @throws   BeansException 定义的bean异常
     **/
    void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException;

}
