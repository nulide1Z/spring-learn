package cn.wyw.springframework.beans;

import cn.wyw.springframework.beans.factory.FactoryBean;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyFactoryBean implements FactoryBean<Fruit> {
    @Override
    public Fruit getObject() throws BeansException {
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>(6);
            hashMap.put("test1", "test11");
            hashMap.put("test2", "test22");
            hashMap.put("test3", "test33");
            return "poxy  " + method.getName() + ", " + hashMap.get(args[0].toString());
        };
        return (Fruit) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Fruit.class}, invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return Fruit.class;
    }

    @Override
    public Boolean isSingleton() {
        return Boolean.TRUE;
    }
}
