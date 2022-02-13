package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 1z
 * @date 2022/2/12 0:37
 */
public class FruitFactory implements FactoryBean<Fruit> {
    @Override
    public Fruit getObject() throws BeansException {
        return (Fruit) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Fruit.class}, (proxy, method, args) -> "被代理啦 " + args + method.getName());
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public Boolean isSingleton() {
        return true;
    }
}
