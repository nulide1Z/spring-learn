package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.PropertyValue;
import cn.wyw.springframework.beans.PropertyValues;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.wyw.springframework.core.io.DefaultResourceLoader;
import cn.wyw.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * 占位符配置器
 *
 * @author 1z
 * @date 2022/1/30 23:05
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanDefinitionName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValue()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }
                    String str = (String) value;
                    StringBuffer stringBuffer = new StringBuffer(str);
                    int start = stringBuffer.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int end = stringBuffer.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (start != -1 && end != -1 && start < end){
                        String propKey = stringBuffer.substring(start + 2, end);
                        String propVal = properties.getProperty(propKey);
                        stringBuffer.replace(start, end +1, propVal);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), stringBuffer));
                    }
                }
            }
        } catch (IOException e) {
            throw new BeansException("could no load properties", e);
        }
    }
}
