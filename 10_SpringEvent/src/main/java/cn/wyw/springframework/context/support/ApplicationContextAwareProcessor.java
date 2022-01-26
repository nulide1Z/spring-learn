package cn.wyw.springframework.context.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.config.BeanPostProcessor;
import cn.wyw.springframework.context.ApplicationContext;
import cn.wyw.springframework.context.ApplicationContextAware;

/**
 * 应用上下文感知 处理器
 * @author 1z
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(this.applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
