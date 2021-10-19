package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认可展示 Bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/7 15:44
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public Object registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        return beanDefinitionMap.put(beanName, beanDefinition);
    }
}
