package cn.wyw.springfreamework;

import cn.wyw.springfreamework.factory.config.BeanDefinition;
import cn.wyw.springfreamework.factory.support.DefaultBeanListableBeanFactory;
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
         BeanDefinition beanDefinition = new BeanDefinition(aservice.class);
         DefaultBeanListableBeanFactory defaultBeanListableBeanFactory = new DefaultBeanListableBeanFactory();
         defaultBeanListableBeanFactory.registerBean("aservice", beanDefinition);

         // 第一次获取bean
         aservice aservice = (aservice)defaultBeanListableBeanFactory.getBean("aservice");
         aservice.test();

         // 第二次获取bean
         aservice bservice = (aservice)defaultBeanListableBeanFactory.getBean("aservice");
         bservice.test();

     }

}
