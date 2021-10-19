package cn.wyw.springfreamework.beans;

import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import cn.wyw.springfreamework.beans.factory.config.BeanReference;
import cn.wyw.springfreamework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 *
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:50
 */
public class test {

    @Test
    public void testBeanReference(){
        // 创建factory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 定义内部对象beanDefinition
        BeanDefinition appleBeanDefinition = new BeanDefinition(Apple.class);
        defaultListableBeanFactory.registerBeanDefinition("apple", appleBeanDefinition);

        // 配置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "123"));
        propertyValues.addPropertyValue(new PropertyValue("apple", new BeanReference("apple")));

        // 注册bean
        BeanDefinition plateBeanDefinition = new BeanDefinition(Plate.class, propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("plate", plateBeanDefinition);

        // 获取bean
        Plate plate = (Plate) defaultListableBeanFactory.getBean("plate");
        plate.getApple("wyww");
    }

}
