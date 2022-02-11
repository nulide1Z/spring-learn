package cn.wyw.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.wyw.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.wyw.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import cn.wyw.springframework.core.io.Resource;
import cn.wyw.springframework.core.io.ResourceLoader;
import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.PropertyValue;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.beans.factory.config.BeanReference;
import cn.wyw.springframework.beans.factory.support.BeanDefinitionRegister;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;

/**
 * xml 读取BeanDefinition
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 16:34
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegister register) {
        super(register);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegister register,
                                   ResourceLoader resourceLoader) {
        super(register, resourceLoader);
    }

    @Override
    public void loadBeanDefinition(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException | DocumentException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinition(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinition(resource);
    }

    /***
     * 加载xml 中的配置, 并且注册为bean
     *
     * @param inputStream  输入流
     * @author wangyuwen
     * @date 2021/10/21 - 15:14
     **/
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        Element root = document.getRootElement();
        Element componentScan = root.element("component-scan");
        if (null != componentScan) {
            String basePackage = componentScan.attributeValue("base-package");
            if (StrUtil.isEmpty(basePackage)) {
                throw new BeansException("base-package attribute cant be null or empty");
            }
            this.scanPackage(basePackage);
        }

        List<Element> beanList = root.elements("bean");

        for (Element bean : beanList) {

            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");
            String initMethod = bean.attributeValue("init-method");
            String destroyMethodName = bean.attributeValue("destroy-method");
            String scope = bean.attributeValue("scope");

            // 获取class
            Class<?> clazz = Class.forName(className);
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);
            if (StrUtil.isNotEmpty(scope)) {
                beanDefinition.setScope(scope);
            }
            List<Element> properties = bean.elements("property");
            for (Element property : properties) {
                // 获取属性
                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");
                Object value = StrUtil.isEmpty(attrRef) ? attrValue : new BeanReference(attrRef);
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            // 判断是否重复声明
            if (getRegister().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册 bean
            getRegister().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    public void scanPackage(String scanPath) {
        String[] basePackages = StrUtil.splitToArray(scanPath, ',');
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(super.getRegister());
        scanner.doScan(basePackages);

    }
}
