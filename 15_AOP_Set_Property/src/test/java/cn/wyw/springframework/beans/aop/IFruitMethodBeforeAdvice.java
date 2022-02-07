package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author 1z
 * @date 2022/2/8 0:39
 */
public class IFruitMethodBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("在环绕前代理方法了");
    }
}
