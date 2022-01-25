package cn.wyw.springframework.beans.factory.config;

/**
 * 自动装配的工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/21 16:42
 */
public interface AutowireCapableBeanFactory {

    Object applyBeanPostProcessorsBeforeInitialize(Object bean, String beanName);

    Object applyBeanPostProcessorsAfterInitialize(Object bean, String beanName);

}
