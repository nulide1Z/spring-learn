package cn.wyw.springfreamework.factory.support;

import cn.wyw.springfreamework.factory.BeanException;
import cn.wyw.springfreamework.factory.config.BeanDefinition;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认可以展示的bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 23:23
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    @Override
    public void registerBean(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null ){
            throw new BeanException("No bean named :"+ beanName);
        }
        return beanDefinition;
    }
}
