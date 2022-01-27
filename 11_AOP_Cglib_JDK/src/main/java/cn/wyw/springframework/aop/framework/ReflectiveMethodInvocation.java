package cn.wyw.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author 1z
 * @date 2022/1/26 10:56
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    protected final Object target;

    protected final Method method;

    protected final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object getThis() {
        return this;
    }

    @Override
    public Object proceed() throws Throwable {
        return null;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return null;
    }

    public Object getTarget() {
        return target;
    }
}
