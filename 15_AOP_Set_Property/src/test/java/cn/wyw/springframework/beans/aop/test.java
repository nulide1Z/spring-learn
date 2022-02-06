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
    public void testSpringAop(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Fruit iFruit = null;
        try {
            iFruit = context.getBean("iFruit", Fruit.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String dd = iFruit.getByName("qq");
        String d1 = iFruit.register("d1");
        System.out.println(dd);
        System.out.println(d1);

    }

    @Test
    public void test_auto_write(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        Fruit iFruit = applicationContext.getBean("iFruit", Fruit.class);
        System.out.println("测试结果：" + iFruit);
    }

    @Test
    public void test_scan(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        Fruit iFruit = applicationContext.getBean("iFruit", Fruit.class);
        System.out.println("测试结果：" + iFruit.register("doudizhu"));
    }
}
