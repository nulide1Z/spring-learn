package cn.wyw.springframework.beans.factory.support;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.core.io.Resource;
import cn.wyw.springframework.core.io.ResourceLoader;

/**
 * BeanDefinition 读取接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 14:52
 */
public interface BeanDefinitionReader {

    /**
     * 获取注册器
     * @return bean定义注册器
     */
    BeanDefinitionRegister getRegister();

    /**
     * 获取资源加载器
     * @return 资源加载器
     */
    ResourceLoader getResourceLoader();

    /**
     *  加载资源
     * @param resource 资源
     * @throws BeansException bean异常
     */
    void loadBeanDefinition(Resource resource) throws BeansException;

    /**
     *  加载多个资源
     * @param resource 资源
     * @throws BeansException bean异常
     */
    void loadBeanDefinitions(Resource... resource) throws BeansException;

    /**
     *  加载路径下的资源
     * @throws BeansException bean异常
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     *  加载路径下多个资源
     * @throws BeansException bean异常
     */
    void loadBeanDefinitions(String... locations) throws BeansException;

}
