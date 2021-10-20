package cn.wyw.springfreamework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.wyw.springfreamework.beans.BeansException;
import cn.wyw.springfreamework.beans.PropertyValue;
import cn.wyw.springfreamework.beans.PropertyValues;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import cn.wyw.springfreamework.beans.factory.config.BeanReference;
import cn.wyw.springfreamework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.wyw.springfreamework.beans.factory.support.BeanDefinitionRegister;
import cn.wyw.springfreamework.core.io.Resource;
import cn.wyw.springfreamework.core.io.ResourceLoader;
import com.sun.deploy.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
            try (InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
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

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断元素
            if (!(childNodes.item(i) instanceof Element)) {
                continue;
            }
            // 判断对象
            if (!"bean".equals(childNodes.item(i).getNodeName())) {
                continue;
            }
            // 解析标签
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            // 获取class
            Class<?> clazz = Class.forName(className);
            String beanName = (id == null || id.length() == 0) ? name : id;
            if (beanName == null || beanName.length() == 0) {
                beanName = clazz.getSimpleName();
            }
            // 定义beanDefinition
            BeanDefinition beanDefinition = new BeanDefinition(clazz);

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) {
                    continue;
                }
                if (!("property".equals(bean.getChildNodes().item(j).getNodeName()))) {
                    continue;
                }
                Element property = (Element) bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 获取属性值
                Object value = StrUtil.isEmpty(attrValue) ? new BeanReference(attrRef) : attrValue;
                PropertyValues propertyValues = new PropertyValues();
                propertyValues.addPropertyValue(new PropertyValue(attrName, value));
                beanDefinition.setPropertyValue(propertyValues);
            }
            if (getRegister().containsBeanDefinition(beanName)){
                throw new BeansException("Duplicate register xml bean");
            }
            // 注册bean
            getRegister().registerBeanDefinition(beanName, beanDefinition);
        }


    }
}
