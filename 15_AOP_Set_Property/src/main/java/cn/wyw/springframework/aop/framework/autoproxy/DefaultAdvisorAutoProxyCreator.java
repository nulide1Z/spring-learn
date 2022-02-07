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
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
        return null;
    }



    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) {
        return true;
    }

    /**
     * 是否基础类
     *
     * @param beanClass bean 类型
     * @return 是否基础类
     */
    private boolean isInfrastructureClass(Class<?> beanClass) {
        return (Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 初始化bean 之后
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (this.isInfrastructureClass(bean.getClass())){
            return bean;
        }
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(bean.getClass())){
                continue;
            }
            TargetSource targetSource = new TargetSource(bean);
            AdvisedSupport advisedSupport = new AdvisedSupport();
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTarget(false);
            return new ProxyFactory(advisedSupport).getProxy();
        }
        return bean;
    }



    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pv, Object bean, String beanName) {
        return pv;
    }
}
