package cn.wyw.springfreamework.beans.factory.config;

import cn.wyw.springfreamework.beans.PropertyValue;
import cn.wyw.springfreamework.beans.PropertyValues;

/**
 * bean 定义
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:35
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues: new PropertyValues();
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValue(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
