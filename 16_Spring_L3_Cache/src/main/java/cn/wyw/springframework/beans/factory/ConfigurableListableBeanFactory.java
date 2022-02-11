package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.config.*;
import cn.wyw.springframework.util.StringValueResolver;

/**
 * 大多数可列出的 bean 工厂要实现的配置接口。除了 {@link ConfigurableBeanFactory} 之外，它还提供了分析和修改 bean 定义以及预实例化单例的工具。
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/21 16:40
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 获取BeanDefinition
     *
     * @param beanName bean名称
     * @return BeanDefinition
     * @throws BeansException bean 异常
     * @author wangyuwen
     * @date 2021/12/3 - 11:44
     **/
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     *  预先实例化单例
     * @param beanFactory bean 工厂
     * @throws BeansException bean 异常
     */
    void preInstantiateSingletons(BeanFactory beanFactory) throws BeansException;


}
