package cn.wyw.springframework.beans;

import cn.hutool.core.io.IoUtil;
import cn.wyw.springframework.beans.factory.support.BeanDefinitionRegister;
import cn.wyw.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.wyw.springframework.beans.factory.xml.XmlBeanDefinitionReader;
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
    public void testClassPath() throws IOException {
        Resource resource = defaultResourceLoader.getResource("classpath:test.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void testFileSystemResource() throws IOException {
        Resource resource = defaultResourceLoader.getResource("src/main/resources/test.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void testResourceLoader() throws IOException {
        // 这里从网上获取资源文件先不测 - -
        Resource resource = defaultResourceLoader.getResource("http://www");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void testBeanLoaderByXMLResource() throws IOException {
        // 加载spring.xml 里的资源
        Resource resource = defaultResourceLoader.getResource("classpath:spring.xml");
        // 通过XmlBeanDefinition 去去遍历读取定义的bean 并且设置属性
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinition(resource);
        // 直接获取已经注册的bean
        Plate plate =  defaultListableBeanFactory.getBean("plate", Plate.class);
        plate.getApple("wyww");
    }

}
