package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;

/**
 * bean 注册
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/8 10:40
 */
public interface BeanDefinitionRegister {
    Object registerBean(String beanName, BeanDefinition beanDefinition);

}
