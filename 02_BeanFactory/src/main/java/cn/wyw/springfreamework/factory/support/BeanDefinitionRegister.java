package cn.wyw.springfreamework.factory.support;

import cn.wyw.springfreamework.factory.config.BeanDefinition;

/**
 * bean 定义 注册接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 23:21
 */
public interface BeanDefinitionRegister {

    /**
     * 注册bean
     *
     * @param beanName bean 名称
     * @param beanDefinition  bean 定义
     * @author wangyuwen
     * @date 2021/9/1 - 0:42
     **/
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
