package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.core.io.DefaultResourceLoader;
import cn.wyw.springfreamework.core.io.ResourceLoader;

/**
 * 抽象BeanDefinition 读取类
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 16:28
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegister register;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegister register) {
        this(register, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegister register,
        ResourceLoader resourceLoader) {
        this.register = register;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegister getRegister() {
        return register;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
