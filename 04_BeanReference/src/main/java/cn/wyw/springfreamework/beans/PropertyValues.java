package cn.wyw.springfreamework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性集合
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/18 18:17
 */
public class PropertyValues {

    private List<PropertyValue> list = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        list.add(propertyValue);
    }

    public PropertyValue[] getPropertyValue (){
        return this.list.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyVlaue(String name){
        for (PropertyValue propertyValue : list) {
            if (propertyValue.getName() == name){
                return propertyValue;
            }
        }
        return null;
    }

}
