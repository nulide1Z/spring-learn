package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 工厂bean 注册支持
 * @author 1z
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegister {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();;

    public Object getCachedObjectForFactoryBean(String beanName){
        Object o = factoryBeanObjectCache.get(beanName);
        return (NULL_OBJECT != o ? o : null );
    }

    public Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName){
        if (factoryBean.isSingleton()){
            Object o =this.factoryBeanObjectCache.get(beanName);
            if (null == o){
                o = this.doGetObjectFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, null == o ? NULL_OBJECT : o);
                return (NULL_OBJECT != o ? o : null);
            }
        }
        return this.doGetObjectFromFactoryBean(factoryBean, beanName);
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName){
        try {
            System.out.println("bean name :" + beanName);
            return  factoryBean.getObject();
        } catch (BeansException e) {
            throw new BeansException("FactoryBean threw exception on object [" + beanName + "] creation", e);
        }
    }
}
