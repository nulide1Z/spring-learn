package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.factory.config.SingletonBeanRegister;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认单例注册接口实现类
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:38
 */
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {

    private Map<String, Object> singletonMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject){
        singletonMap.put(beanName, singletonObject);
    }
}
