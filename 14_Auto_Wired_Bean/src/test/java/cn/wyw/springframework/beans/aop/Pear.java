package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 1z
 * @date 2022/2/1 15:05
 */
@Component
public class Pear {
    private static Map<String, String> carMap = new HashMap<>();

    static {
        carMap.put("dianzhagnli", "13张");
        carMap.put("doudizhu", "17张");
    }

    public String getPear(String carName){
        return carMap.get(carName);
    }
}
