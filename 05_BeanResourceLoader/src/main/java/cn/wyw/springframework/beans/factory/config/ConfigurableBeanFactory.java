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

}
