package cn.wyw.springframework.beans.factory.config;

import cn.wyw.springframework.beans.BeansException;

/**
 * 此接口用来在实例化之前
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/3 10:54
 */
public interface BeanPostProcessor {

    /**
     * 在bean 实例化之前对bean 进行操作
     *
     * @param bean bean
     * @param beanName bean名称
     * @return
     * @throws BeansException 定义的bean 异常
     * @author wangyuwen
     * @date 2021/12/3 - 10:58
     **/
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean 实例化之后对bean 进行操作
     *
     * @param bean bean
     * @param beanName bean名称
     * @return
     * @throws BeansException 定义的bean 异常
     * @author wangyuwen
     * @date 2021/12/3 - 10:58
     **/
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
