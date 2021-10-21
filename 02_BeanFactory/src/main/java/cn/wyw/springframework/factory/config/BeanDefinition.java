package cn.wyw.springframework.factory.config;

/**
 * bean 定义
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 00:38
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
