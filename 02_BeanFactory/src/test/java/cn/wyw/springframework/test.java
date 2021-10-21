package cn.wyw.springframework;

import cn.wyw.springframework.factory.config.BeanDefinition;
import cn.wyw.springframework.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * 测试方法
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/1 00:45
 */
public class test {

     @Test
    public void testA(){
         BeanDefinition beanDefinition = new BeanDefinition(cn.wyw.springframework.aservice.class);
         DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
         defaultListableBeanFactory.registerBeanDefinition("aservice", beanDefinition);

         // 第一次获取bean
         cn.wyw.springframework.aservice aservice = (cn.wyw.springframework.aservice) defaultListableBeanFactory.getBean("aservice");
         aservice.test();

         // 第二次获取bean
         cn.wyw.springframework.aservice bservice = (cn.wyw.springframework.aservice) defaultListableBeanFactory.getBean("aservice");
         bservice.test();

     }

}
