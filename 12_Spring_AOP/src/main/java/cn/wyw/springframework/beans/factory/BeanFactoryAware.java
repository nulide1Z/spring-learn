package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;

/**
 * 感知BeanFactory
 * @author 1z
 */
public interface BeanFactoryAware extends Aware {

    /**
     *  设置bean factory
     * @param beanFactory bean 工厂
     * @throws BeansException bean 异常
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
