package cn.wyw.springframework.beans.factory.config;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.HierarchicalBeanFactory;
import cn.wyw.springframework.beans.factory.ListableBeanFactory;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;

/**
 * 可配置bean 工厂接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/21 16:30
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegister {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加bean后置处理器
     *
     * @param beanPostProcessor 后置处理器
     * @author wangyuwen
     * @date 2021/12/7 - 14:50
     * @throws BeansException 异常信息
     **/
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws BeansException;

    /**
     * 销毁单例对象
     */
    void destroySingletons();

}
