package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 环绕
 * @author 1z
 * @date 2022/1/30 12:15
 */
public class IFruitBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("测试环绕: " + method.getName());
    }
}
