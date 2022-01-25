package cn.wyw.springframework.beans;

import cn.wyw.springframework.beans.factory.*;
import cn.wyw.springframework.context.ApplicationContext;
import cn.wyw.springframework.context.ApplicationContextAware;

/**
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:51
 */
public class Plate implements ApplicationContextAware, BeanFactoryAware, BeanClassLoaderAware, BeanNameAware {

    private String name;

    private Apple apple;

    private String color;

    private String size;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAppleName() {
        return apple.getByName(this.name) + " color:" + this.color + " size:" + size;
    }

    public void getAppleName(String name) {
        System.out.println(apple.getByName(name));
    }

    public String getName() {
        return name;
    }

    public Apple getApple() {
        return apple;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) throws BeansException {
        System.out.println("set bean class loader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) throws BeansException {
        System.out.println(" set bean name");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
