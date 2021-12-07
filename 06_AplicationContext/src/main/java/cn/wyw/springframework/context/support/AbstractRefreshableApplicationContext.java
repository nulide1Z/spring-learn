package cn.wyw.springframework.context.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyw.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 抽象可刷新的应用程序上下文
 * 初始化BeanFactory
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/3 15:18
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     *  加载BeanDefinition
     *
     * @param beanFactory bean 工厂
     * @throws BeansException 异常
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
