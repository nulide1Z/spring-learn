package cn.wyw.springfreamework.beans.factory.config;

/**
 * bean 引用
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 13:43
 */
public class BeanReference {

    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
