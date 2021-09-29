package cn.wyw.springfreamework;

import cn.wyw.springfreamework.factory.config.BeanDefinition;
import cn.wyw.springfreamework.factory.support.DefaultListableBeanFactory;
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
         BeanDefinition beanDefinition = new BeanDefinition(cn.wyw.springfreamework.aservice.class);
         DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
         defaultListableBeanFactory.registerBeanDefinition("aservice", beanDefinition);

         // 第一次获取bean
         cn.wyw.springfreamework.aservice aservice = (cn.wyw.springfreamework.aservice) defaultListableBeanFactory.getBean("aservice");
         aservice.test();

         // 第二次获取bean
         cn.wyw.springfreamework.aservice bservice = (cn.wyw.springfreamework.aservice) defaultListableBeanFactory.getBean("aservice");
         bservice.test();

     }

}
