package cn.wyw.springframework.context.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyw.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.wyw.springframework.beans.factory.config.BeanPostProcessor;
import cn.wyw.springframework.context.ConfigurableApplicationContext;
import cn.wyw.springframework.core.io.DefaultResourceLoader;
import java.util.Map;

/**
 * 抽象应用上下文
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/2 14:42
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    @Override
    public void refresh() {

        // 1. 创建BeanFactory, 加载BeanDefinition
        refreshBeanFactory();

        // 2. 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在bean 实例化之前, 调BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context)
        this.invokeBeanFactoryPostProcessor(beanFactory);
        // 4. BeanPostProcess 需要首先被加载
        registerBeanPostProcessors(beanFactory);
        // 5. 提前实例化单例bean
         beanFactory.preInstantiateSingletons(beanFactory);

    }

    private  void invokeBeanFactoryPostProcessor(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beansOfType.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor value : beansOfType.values()) {
            beanFactory.addBeanPostProcessor(value);
        }
    }



    /**
     * 刷新BeanFactory
     *
     * @throws BeansException 定义的bean 异常
     * @author wangyuwen
     * @date 2021/12/3 - 11:28
     **/
    protected abstract void refreshBeanFactory() throws BeansException;

    /**
     * 获取可配置展示的BeanFactory
     *
     * @return ConfigurableListableBeanFactory
     * @author wangyuwen
     * @date 2021/12/3 - 11:28
     **/
    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
