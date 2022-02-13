package cn.wyw.springframework.beans.factory.config;

import cn.wyw.springframework.beans.BeansException;

/**
 * 单例bean 注册接口定义
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:37
 */
public interface SingletonBeanRegister {

    /**
     * 根据名称获取单例Bean
     *
     * @param beanName bean名称
     * @return  单例bean
     * @author wangyuwen
     * @date 2021/9/29 - 14:32
     **/
    Object getSingleton(String beanName);

    /**
     * 注册单例
     * @param beanName bean 名称
     * @param singletonObject 单例对象
     * @throws BeansException  bean异常
     */
    void registerSingleton(String beanName, Object singletonObject) throws BeansException;

}
