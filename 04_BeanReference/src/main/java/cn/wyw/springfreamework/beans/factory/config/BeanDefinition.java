package cn.wyw.springfreamework.beans.factory.config;

/**
 * bean 定义
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:35
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
