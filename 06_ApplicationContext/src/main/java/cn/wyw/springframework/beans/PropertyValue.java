package cn.wyw.springframework.beans;

/**
 * 属性
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/18 18:15
 */
public class PropertyValue {

    /**
     *  名称
     **/
    private final String name;

    /**
     *  属性
     **/
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
