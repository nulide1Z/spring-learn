package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.DisposableBean;
import cn.wyw.springframework.beans.factory.ObjectFactory;
import cn.wyw.springframework.beans.factory.config.SingletonBeanRegister;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认单例注册接口实现类
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:38
 */
public class DefaultSingletonBeanRegister implements SingletonBeanRegister {

    protected final static Object NULL_OBJECT = new Object();

    /**
     * 一级缓存，普通对象
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 二级缓存，提前暴漏对象，没有完全实例化的对象
     */
    protected final Map<String, Object> earlySingletonObjects = new HashMap<String, Object>();

    /**
     * 三级缓存，存放代理对象
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String,ObjectFactory<?>>();

    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject){
            singletonObject = earlySingletonObjects.get(beanName);
            // 判断二级缓存中是否有对象，这个对象就是代理对象，因为只有代理对象才会放到三级缓存中
            if (null == singletonObject){
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (null != singletonFactory ){
                    singletonObject = singletonFactory.getObject();
                    // 把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存中
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }


    @Override
    public void registerSingleton(String beanName, Object singletonObject) throws BeansException {
        singletonObjects.put(beanName, singletonObject);
        singletonFactories.remove(beanName);
        earlySingletonObjects.remove(beanName);

    }

    /**
     * 添加到单例工厂
     * @param beanName bean 名称
     * @param singletonFactory 单例工厂
     */
    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory){
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    /**
     * 注册销毁bean
     *
     * @param beanName       bean 名称
     * @param disposableBean 销毁bean
     */
    public void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        synchronized (this.disposableBeans) {
            disposableBeans.put(beanName, disposableBean);
        }
    }


    /**
     * 销毁bean
     */
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.get(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName + "' throw an exception", e);
            }
        }
       /* for (String beanName : disposableBeans.keySet()) {
            DisposableBean removeDisposableBean = disposableBeans.remove(beanName);
            try {
                removeDisposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName+ "' throw an exception" , e);
            }
        }*/
    }


}
