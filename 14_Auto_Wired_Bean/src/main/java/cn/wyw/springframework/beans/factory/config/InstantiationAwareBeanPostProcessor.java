package cn.wyw.springframework.beans.factory.config;

import cn.wyw.springframework.beans.PropertyValues;

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


    /**
     * 后置处理属性值
     * @param pv 属性值
     * @param bean bean
     * @param beanName bean 名称
     * @return 属性值对象
     */
    PropertyValues postProcessPropertyValue(PropertyValues pv, Object bean, String beanName);


}
