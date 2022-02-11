package cn.wyw.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.cglib.CglibUtil;
import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.PropertyValue;
import cn.wyw.springframework.beans.PropertyValues;
import cn.wyw.springframework.beans.factory.BeanFactory;
import cn.wyw.springframework.beans.factory.BeanFactoryAware;
import cn.wyw.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.wyw.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.wyw.springframework.util.ClassUtil;

import java.lang.reflect.Field;

/**
 * 自动注入注解后置处理器
 *
 * @author 1z
 * @date 2022/1/31 17:20
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    public AutowiredAnnotationBeanPostProcessor() {
    }

    public AutowiredAnnotationBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) {
        Class<?> clazz = bean.getClass();
        clazz = ClassUtil.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (null != valueAnnotation) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }

        }

        for (Field field : declaredFields) {
            AutoWired autoWiredAnnotation = field.getAnnotation(AutoWired.class);
            if (null != autoWiredAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Object dependentBean = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }
        return pvs;
    }




}
