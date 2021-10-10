package cn.wyw.springfreamework;

import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import cn.wyw.springfreamework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * 测试方法
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/30 16:00
 */
public class test {

    @Test
    public void testStrategy(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(AService.class);
        defaultListableBeanFactory.registerBean("AService", beanDefinition);

        AService bean = (AService) defaultListableBeanFactory.getBean("AService", "罗马哥");
        bean.test();

    }

}
