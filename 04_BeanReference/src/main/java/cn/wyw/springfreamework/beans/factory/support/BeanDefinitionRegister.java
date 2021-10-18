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
     * TODO 添加方法注释
     *
     * @param beanName
     * @param beanDefinition
     * @return
     * @author wangyuwen
     * @date 2021/9/30 - 16:03
     **/
    Object registerBean(String beanName, BeanDefinition beanDefinition);

}
