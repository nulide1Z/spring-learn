package cn.wyw.springframework.aop.framework.autoproxy;

import cn.wyw.springframework.aop.*;
import cn.wyw.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.PropertyValue;
import cn.wyw.springframework.beans.PropertyValues;
import cn.wyw.springframework.beans.factory.BeanFactory;
import cn.wyw.springframework.beans.factory.BeanFactoryAware;
import cn.wyw.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.wyw.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

/**
 * 默认顾问自动代理创建者
 *
 * @author 1z
 * @date 2022/1/29 20:52
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessorBeforeInstantiation(Class<?> beanClass, String beanName) {
        if (this.isInfrastructureClass(beanClass)) {
            return null;
        }
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(beanClass)) {
                continue;
            }

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

            return new ProxyFactory(advisedSupport).getProxy();
        }
        return null;
    }

    /**
     * 是否基础类
     *
     * @param beanClass bean 类型
     * @return
     */
    private boolean isInfrastructureClass(Class<?> beanClass) {
        return (Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValue(PropertyValues pv, Object bean, String beanName) {
        return pv;
    }
}
