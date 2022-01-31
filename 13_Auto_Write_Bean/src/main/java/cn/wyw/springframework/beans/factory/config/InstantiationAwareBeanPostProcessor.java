package cn.wyw.springframework.beans.factory.config;

import cn.wyw.springframework.beans.BeansException;

/**
 *
 *  实例化感知 Bean 后置处理器
 *
 * @author 1z
 * @date 2022/1/29 19:30
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在 实例化之前后置处理
     * @param beanClass bean 的类型
     * @param beanName bean 名称
     * @return bean
     */
   Object postProcessorBeforeInstantiation(Class<?> beanClass, String beanName);
}
