package cn.wyw.springframework.aop.framework;

import cn.wyw.springframework.aop.AdvisedSupport;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib aop 代理
 * @author 1z
 * @date 2022/1/26 10:55
 */
public class Cglib2AopProxy implements AopProxy{

    private final  AdvisedSupport advisedSupport;

    public Cglib2AopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }



    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(advisedSupport.getTargetSource().getTarget().getClass());
        enhancer.setInterfaces(advisedSupport.getTargetSource().getTargetClass());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advisedSupport));
        return enhancer.create();
    }

    public static class DynamicAdvisedInterceptor implements MethodInterceptor {
        private final  AdvisedSupport advisedSupport;

        public DynamicAdvisedInterceptor(AdvisedSupport advisedSupport) {
            this.advisedSupport = advisedSupport;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            CglibMethodInvocation cglibMethodInvocation = new CglibMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args, proxy);
            if (advisedSupport.getMethodMatcher().matches(method, advisedSupport.getTargetSource().getTarget().getClass())){
                return advisedSupport.getMethodInterceptor().invoke(cglibMethodInvocation);
            }
            return cglibMethodInvocation.proceed();
        }
    }

    public static class CglibMethodInvocation extends ReflectiveMethodInvocation{
        private final  MethodProxy methodProxy;
        public CglibMethodInvocation(Object target, Method method, Object[] arguments, MethodProxy methodProxy) {
            super(target, method, arguments);
            this.methodProxy = methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target, this.arguments);
        }
    }



}
