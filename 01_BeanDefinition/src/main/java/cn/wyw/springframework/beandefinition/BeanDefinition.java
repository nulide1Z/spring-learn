package cn.wyw.springframework.beandefinition;

/**
 * bean definition
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/29 23:48
 */
public class BeanDefinition {

    private Object bean;

    public Object getBean() {
        return bean;
    }


    public BeanDefinition(Object bean) {
        this.bean = bean;
    }
}
