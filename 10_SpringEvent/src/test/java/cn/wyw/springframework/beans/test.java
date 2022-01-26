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
        context.publishEvent(new PlateEvent(context, "dd", "eiei"));
        context.registerShutdownHook();

    }

}
