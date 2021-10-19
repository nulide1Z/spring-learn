package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;

/**
 * bean 注册
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/8 10:40
 */
public interface BeanDefinitionRegister {

    /**
     * 注册beanDefinition
     *
     * @param beanName bean 名称
     * @param beanDefinition bean 定义
     * @return
     * @author wangyuwen
     * @date 2021/9/30 - 16:03
     **/
    Object registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
