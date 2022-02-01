package cn.wyw.springframework.aop.framework.adapter;

import cn.wyw.springframework.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 通知拦截器之前的方法
 * @author 1z
 * @date 2022/1/29 19:22
 */
public class MethodBeforeAdviseInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice advice;

    public MethodBeforeAdviseInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    public MethodBeforeAdviseInterceptor() {
    }

    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
         this.advice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
         return invocation.proceed();
    }
}
