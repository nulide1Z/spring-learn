package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.BeansException;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * 简易实例化策略实现
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 17:34
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args)
        throws BeansException {

        Class clazz = beanDefinition.getBeanClass();

        try {
            if (null != constructor){
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException  | IllegalAccessException |  InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("instantiate failure [" + clazz.getName()+ "]", e);
        }
    }
}
