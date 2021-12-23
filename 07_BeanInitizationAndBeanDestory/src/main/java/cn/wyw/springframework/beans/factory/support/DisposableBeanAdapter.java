package cn.wyw.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.DisposableBean;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() {
        // 实现接口 DisposableBean
        if (bean instanceof DisposableBean){
            ((DisposableBean)bean).destroy();
        }
        // 配置信息 destroy-method
          if (StrUtil.isNotBlank(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))){
              Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
              if (null == destroyMethod){
                  throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName  +"'");
              }
              destroyMethod.invoke(bean);

          }

    }
}
