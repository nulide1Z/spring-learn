package cn.wyw.springframework.beans.factory.config;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.HierarchicalBeanFactory;
import cn.wyw.springframework.beans.factory.ListableBeanFactory;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.util.StringValueResolver;

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

    /**
     * 添加字符串值解析器
     * @param valueResolver 字符串解析器
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * 处理嵌入的值
     * @param value 值
     */
    String resolveEmbeddedValue(String value);

}
