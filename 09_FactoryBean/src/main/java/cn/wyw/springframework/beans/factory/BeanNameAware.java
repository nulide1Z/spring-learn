package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;

/**
 *  bean 名称 感知
 * @author 1z
 */
public interface BeanNameAware  extends Aware{

    /**
     *  设置bean 名称
     * @param beanName bean 名称
     * @throws BeansException bean 异常
     */
    void setBeanName(String beanName) throws BeansException;
}
