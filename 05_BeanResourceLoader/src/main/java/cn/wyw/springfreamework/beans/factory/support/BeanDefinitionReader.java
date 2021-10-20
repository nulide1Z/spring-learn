package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.BeansException;
import cn.wyw.springfreamework.core.io.Resource;
import cn.wyw.springfreamework.core.io.ResourceLoader;

/**
 * BeanDefinition 读取接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 14:52
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegister getRegister();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
