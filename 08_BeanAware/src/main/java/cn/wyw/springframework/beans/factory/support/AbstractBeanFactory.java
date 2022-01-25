package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.factory.BeanFactory;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.beans.factory.config.BeanPostProcessor;
import cn.wyw.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.wyw.springframework.util.ClassUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * bean 工厂模板方法
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:46
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtil.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return doGetBean(name, args);
    }

    protected Object doGetBean(final String beanName, Object[] args){
        Object singletonBean = getSingleton(beanName);
        if (null != singletonBean){
            return singletonBean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return (T) getBean(name);
    }

    /**
     * 获取BeanDefinition 模板方法
     *
     * @param beanName bean名称
     * @return beanDefinition
     * @author wangyuwen
     * @date 2021/9/29 - 16:48
     **/
    protected abstract BeanDefinition getBeanDefinition(String beanName);

    /**
     * 创建bean 模板方法
     *
     * @param beanName bean 名称
     * @param beanDefinition bean 定义
     * @param args 参数
     * @return Object 创建的bean
     * @author wangyuwen
     * @date 2021/9/29 - 16:51
     **/
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    /**
     *  获取bean 后置处理器
     * @return 后置处理器集合
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        beanPostProcessors.remove(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
