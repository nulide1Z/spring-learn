package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.factory.config.BeanDefinition;

/**
 * bean 注册
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/8 10:40
 */
public interface BeanDefinitionRegister {

    /**
     * 注册bean
     *
     * @param beanName bean名称
     * @param beanDefinition bean 定义
     * @return 返回值
     * @author wangyuwen
     * @date 2021/9/30 - 16:03
     **/
    Object registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();

}
