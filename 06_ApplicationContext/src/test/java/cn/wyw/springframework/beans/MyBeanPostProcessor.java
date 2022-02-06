package cn.wyw.springframework.beans;

import cn.wyw.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 自定义的bean 后置处理器
 *
 * @author Administrator
 * @version 1.0
 * @date 2021-12-06 18:12
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("plate".equals(beanName)){
            Plate plate = (Plate) bean;
            plate.setSize("5");
            System.out.println("bean 实例化之前赋值 "+plate);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("plate".equals(beanName)){
            Plate plate = (Plate) bean;
            plate.setColor("yellow");
            System.out.println("bean 实例化之后赋值 "+plate);
        }
        return bean;
    }
}
