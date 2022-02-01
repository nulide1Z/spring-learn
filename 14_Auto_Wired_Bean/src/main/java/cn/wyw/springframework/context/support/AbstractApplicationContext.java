package cn.wyw.springframework.context.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyw.springframework.beans.factory.PropertyPlaceholderConfigurer;
import cn.wyw.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.wyw.springframework.beans.factory.config.BeanPostProcessor;
import cn.wyw.springframework.context.ApplicationListener;
import cn.wyw.springframework.context.ConfigurableApplicationContext;
import cn.wyw.springframework.context.event.*;
import cn.wyw.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * 抽象应用上下文
 * 定义refresh 相关的模板方法, 对bean 实例化之前和实例化之后做自定义的操作
 * 继承了 默认的资源加载器, 实现了可以配置的应用上下文
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/2 14:42
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() {

        // 1. 创建BeanFactory, 加载BeanDefinition
        refreshBeanFactory();

        // 2. 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 添加 ApplicationContextAwareProcessor , 让继承自ApplicationContextAwareProcessor 的bean对象能感知到ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4. 在bean 实例化之前, 调BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context)
        this.invokeBeanFactoryPostProcessors(beanFactory);
        // 5. 实例化bean后置处理器  BeanPostProcess 需要首先被加载
        registerBeanPostProcessors(beanFactory);
        // 6. 实例化剩余的单例bean Instantiate all remaining (non-lazy-init) singletons.
        beanFactory.preInstantiateSingletons(beanFactory);

        // 初始化事件发布者
        this.initApplicationEventMulticaster();

        // 注册监听器
        this.registerListeners();

        // 发布容器刷新完成事件
        this.finishRefresh();
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicasterListener(event);
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
    }

    private void registerListeners() {
        Collection<ApplicationListener> listeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : listeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }



    private  void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory){
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beansOfType.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * 注册bean 后置处理器
     * @param beanFactory bean 工厂
     */
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
    public <T> T getBean(Class<T> requiredType) {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        // publish application close event

        publishEvent(new ContextCloseEvent(this));

        // destroy singletons
        getBeanFactory().destroySingletons();
    }


}
