package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.BeansException;
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
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);


    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName bean 名称
     * @return bean定义
     * @throws BeansException bean异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 是否已存在相同bean名称的bean
     * @param beanName bean 名称
     * @return 布尔值
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 获取所有的bean 名称
     * @return bean名称数组
     */
    String[] getBeanDefinitionNames();

}
