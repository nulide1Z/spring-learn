package cn.wyw.springframework.aop;


import org.aopalliance.intercept.MethodInterceptor;

/**
 * 切面支持
 * @author 1z
 * @date 2022/1/26 11:17
 */
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;

    private boolean proxyTarget = true;

    public boolean isProxyTarget() {
        return proxyTarget;
    }

    public void setProxyTarget(boolean proxyTarget) {
        this.proxyTarget = proxyTarget;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
