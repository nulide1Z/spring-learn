package cn.wyw.springframework.aop;

import cn.wyw.springframework.aop.framework.AopProxy;
import cn.wyw.springframework.aop.framework.Cglib2AopProxy;
import cn.wyw.springframework.aop.framework.JdkDynamicAopProxy;

/**
 * 代理工厂
 * @author 1z
 * @date 2022/1/30 9:03
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;


    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return this.createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTarget()){
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
