package cn.wyw.springframework.beans.factory.config;

/**
 * 自动装配的工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/21 16:42
 */
public interface AutowireCapableBeanFactory {

    /**
     * 在初始化之前应用 Bean 后处理器
     * @param bean bean
     * @param beanName bean 名称
     * @return bean
     */
    Object applyBeanPostProcessorsBeforeInitialize(Object bean, String beanName);

    /**
     * 在初始化之后应用 Bean 后处理器
     * @param bean bean
     * @param beanName bean 名称
     * @return bean
     */
    Object applyBeanPostProcessorsAfterInitialize(Object bean, String beanName);

}
