package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.wyw.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 1z
 * @date 2022/1/26 16:53
 */
public class test {


    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Apple apple = applicationContext.getBean("apple" , Apple.class);
        Pear pear = applicationContext.getBean("pear", Pear.class);
        System.out.println(apple.getByName("apple test"));
        System.out.println(pear.getIFruit(" pear get test"));
    }

}
