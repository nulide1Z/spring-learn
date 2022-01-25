package cn.wyw.springframework.beans;

import cn.wyw.springframework.context.support.ClassPathXmlApplicationContext;
import cn.wyw.springframework.core.io.DefaultResourceLoader;
import org.junit.Before;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 *
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:50
 */
public class test {

    @Test
    public void testBeanLoaderByXMLResource() {
        // 初始化bean factory
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();

        // 获取bean 对象调用方法
        Plate plate1 = context.getBean("plate", Plate.class);
        Plate plate2 = context.getBean("plate", Plate.class);

        System.out.println("p1  " + plate1);
        System.out.println("p2  " + plate2);

        // 4. 打印十六进制哈希
        System.out.println(plate1 + " 十六进制哈希 p1：" + Integer.toHexString(plate1.hashCode()));
        System.out.println(plate2 + " 十六进制哈希 p2：" + Integer.toHexString(plate2.hashCode()));
        String appleName = plate1.getAppleName();
        System.out.println(" plate1   : " + appleName);


    }

}
