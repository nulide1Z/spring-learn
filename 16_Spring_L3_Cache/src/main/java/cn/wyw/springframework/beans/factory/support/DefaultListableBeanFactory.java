package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.BeanFactory;
import cn.wyw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyw.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.wyw.springframework.beans.factory.config.BeanPostProcessor;
import cn.wyw.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.util.StringValueResolver;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认可展示 Bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/7 15:44
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister, ConfigurableListableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
         beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        if (beanName == null || beanName.length() == 0){
            throw new IllegalArgumentException("beanName cant be null");
        }
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new LinkedHashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition)->{
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)){
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null){
            throw new BeansException("cant find beanDefinition by bean name:" + beanName);
        }
        return beanDefinition;
    }



    @Override
    public void preInstantiateSingletons(BeanFactory beanFactory) throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }


    @Override
    public <T> T getBean(Class<T> requiredType) {
        List<String> beanNameList=  new ArrayList<>(beanDefinitionMap.size());
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : beanDefinitionMap.entrySet()) {
            Class clazz = beanDefinitionEntry.getValue().getBeanClass();
            if (requiredType.isAssignableFrom(clazz)){
                beanNameList.add(beanDefinitionEntry.getKey());
            }
        }
        if (1 == beanNameList.size()){
            return getBean(beanNameList.get(0),requiredType);
        }

        throw new BeansException("requiredType: " + requiredType +" expected single bean but found "+ beanNameList.size() +" : " +beanNameList);
    }
}
