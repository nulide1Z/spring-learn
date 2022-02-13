package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author 1z
 * @date 2022/2/12 0:49
 */
public class FruitAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(" guan zhu yi bo");
    }
}
