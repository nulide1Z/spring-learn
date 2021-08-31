package cn.wyw.springfreamework.factory.support;

import cn.wyw.springfreamework.factory.config.SingletonBeanRegister;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认单例bean 注册方法实现
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 23:10
 */
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {

    private Map<String, Object> singletonObjectMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjectMap.get(beanName);
    }

    public void addSingleton(String beanName, Object singletonObject){
        singletonObjectMap.put(beanName, singletonObject);
    }
}
