package cn.wyw.springframework.beans;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:51
 */
public class Apple {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("wyww","7987865");
        map.put("type","fustian");
        map.put("name","feudal");
    }

    public String getByName(String name){
        return map.get(name);
    }
}
