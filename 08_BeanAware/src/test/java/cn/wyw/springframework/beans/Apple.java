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

    public void initDataMethod(){
        System.out.println("init data method invoke");
        map.put("wyww","7987865");
        map.put("type","fustian");
        map.put("name","feudal");
        map.put("qwer","测试一下");
    }

    public void destroyDataMethod(){
        System.out.println("destroy data method invoke");
        map.clear();
    }

    public String getByName(String name){
        return map.get(name);
    }
}
