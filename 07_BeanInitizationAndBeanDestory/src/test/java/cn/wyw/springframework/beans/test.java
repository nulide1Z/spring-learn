package cn.wyw.springframework.beans;

import cn.hutool.core.io.IoUtil;
import cn.wyw.springframework.beans.factory.support.BeanDefinitionRegister;
import cn.wyw.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.wyw.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.wyw.springframework.context.support.ClassPathXmlApplicationContext;
import cn.wyw.springframework.core.io.DefaultResourceLoader;
import cn.wyw.springframework.core.io.Resource;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
/**
 *
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:50
 */
public class test {

    private DefaultResourceLoader defaultResourceLoader;

    @Before
    public void initResourceLoader(){
        defaultResourceLoader = new DefaultResourceLoader();
    }



    @Test
    public void testBeanLoaderByXMLResource() {
        // 初始化bean factory
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.registerShutdownHook();

        // 获取bean 对象调用方法
        Plate plate = context.getBean("plate", Plate.class);
        String appleName = plate.getAppleName();
        System.out.println("apple name :  " + appleName);

    }

}
