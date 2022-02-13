package cn.wyw.springframework.beans;

import cn.wyw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.wyw.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义的bean Factory 处理器
 *
 * @author Administrator
 * @version 1.0
 * @date 2021-12-06 18:07
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition plate = configurableListableBeanFactory.getBeanDefinition("plate");
        PropertyValues propertyValues = plate.getPropertyValues();
        PropertyValue propertyValue = new PropertyValue("name","wyww");
        propertyValues.addPropertyValue(propertyValue);
    }
}