package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.DisposableBean;
import cn.wyw.springframework.beans.factory.config.SingletonBeanRegister;

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

    private Map<String, Object> singletonMap = new ConcurrentHashMap<>();
    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject){
        singletonMap.put(beanName, singletonObject);
    }

    /**
     * 注册销毁bean
     * @param beanName bean 名称
     * @param disposableBean 销毁bean
     */
    public void registerDisposableBean(String beanName, DisposableBean disposableBean){
        synchronized (this.disposableBeans){
            disposableBeans.put(beanName, disposableBean);
        }
    }


    /**
     * 销毁bean
     */
    public void destroySingletons(){

        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length -1; i >= 0; i--) {
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.get(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName+ "' throw an exception" , e);
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
