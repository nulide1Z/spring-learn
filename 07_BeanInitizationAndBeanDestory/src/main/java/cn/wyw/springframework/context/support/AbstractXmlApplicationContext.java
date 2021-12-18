package cn.wyw.springframework.context.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.wyw.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 抽象的xml 形式应用上下文
 * 这里是通过XmlBeanDefinitionReader 将类路径定义的 bean 加载
 *
 * @author wangyuwen
 * @date 2021/12/7 - 15:00
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null){
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取当前上下文配置的locations , 在xml 中通常是spring.xml的文件
     *
     * @return 定义的spring bean的路径
     * @author wangyuwen
     * @date 2021/12/7 - 15:01
     **/
    protected abstract String[] getConfigLocations();
}
