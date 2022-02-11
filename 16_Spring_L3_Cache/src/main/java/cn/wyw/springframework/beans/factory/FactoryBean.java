package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;

/**
 *
 * @author 1z
 */
public interface FactoryBean<T> {

    /**
     * 获取对象
     * @return
     */
    T getObject() throws BeansException;

    /**
     * 获取对象 类型
     * @return class 对象类型
     */
    Class<?> getObjectType();

    /**
     * 是否单例
     * @return 是否单例
     */
    Boolean isSingleton();
}
