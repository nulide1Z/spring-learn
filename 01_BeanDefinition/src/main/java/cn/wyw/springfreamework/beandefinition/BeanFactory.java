package cn.wyw.springfreamework.beandefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean factory
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/29 23:53
 */
public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }

    public void registerBean(String beanName, BeanDefinition beanDefinition){
        beanDefinitionMap.put(beanName, beanDefinition);
    }

}
