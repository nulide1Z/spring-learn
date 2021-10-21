package cn.wyw.springframework;

import cn.wyw.springframework.beandefinition.BeanDefinition;
import cn.wyw.springframework.beandefinition.BeanFactory;
import java.cn.wyw.springfreamework.AService;
import org.junit.Test;

/**
 * test
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/29 23:56
 */
public class test {

    @Test
    public void testA(){
        BeanDefinition beanDefinition = new BeanDefinition(new AService());
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("aService", beanDefinition);
        AService aService = (AService)beanFactory.getBean("aService");
        aService.testA();
    }


}
