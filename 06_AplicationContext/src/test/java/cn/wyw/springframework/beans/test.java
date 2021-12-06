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
    public void testBeanLoaderByXMLResource()  {
        // 加载spring.xml 里的资源
        Resource resource = defaultResourceLoader.getResource("classpath:spring.xml");
        // 通过XmlBeanDefinition 去去遍历读取定义的bean 并且设置属性
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
        // 直接获取已经注册的bean
        Plate plate =  defaultListableBeanFactory.getBean("plate", Plate.class);
        plate.getAppleName("wyww");
    }

    @Test
    public void testBeanPostProcessor() throws BeansException{
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 加载spring.xml 里的资源
        Resource resource = defaultResourceLoader.getResource("classpath:spring.xml");
        // 通过XmlBeanDefinition 去去遍历读取定义的bean 并且设置属性
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinition(resource);

        // 加载完BeanDefinition 之后, 实例化bean 之前
        MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        myBeanFactoryPostProcessor.postProcessBeanFactory(defaultListableBeanFactory);

        // bean 实例化之后 , 修改bean的属性信息
        MyBeanPostProcessor myBeanPostProcessor = new MyBeanPostProcessor();
        defaultListableBeanFactory.addBeanPostProcessor(myBeanPostProcessor);
        // 直接获取已经注册的bean
        Plate plate =  defaultListableBeanFactory.getBean("plate", Plate.class);
        System.out.println(plate.getAppleName());
    }

    @Test
    public void testApplicationContext() throws BeansException{
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring-BeanPost.xml");
        Plate plate = classPathXmlApplicationContext.getBean("plate", Plate.class);
        String appleName = plate.getAppleName();
        System.out.println(appleName);

    }

}
