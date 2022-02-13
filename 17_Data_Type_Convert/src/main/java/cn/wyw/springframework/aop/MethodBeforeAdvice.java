package cn.wyw.springframework.aop;

import cn.wyw.springframework.beans.BeansException;
import org.aspectj.weaver.Advice;

import java.lang.reflect.Method;

/**
 * 方法被代理之前
 * @author 1z
 * @date 2022/1/29 19:25
 */
public interface MethodBeforeAdvice extends BeforeAdvice {


    /**
     * 在环绕之前的方法
     *
     * @param method 方法
     * @param args 参数
     * @param target 源
     * @throws Throwable 可抛出的
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
