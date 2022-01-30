package cn.wyw.springframework.beans.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author 1z
 * @date 2022/1/26 20:29
 */
public class IFruitInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long l = System.currentTimeMillis();
        try {
            return  methodInvocation.proceed();
        } finally {
            System.out.println("watch by aop");
            System.out.println("方法名称：" + methodInvocation.getMethod());
            System.out.println("time: "+ (System.currentTimeMillis() - l));
        }
    }
}
