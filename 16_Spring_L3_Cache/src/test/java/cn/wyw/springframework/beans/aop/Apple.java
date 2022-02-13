package cn.wyw.springframework.beans.aop;

import java.util.Random;

/**
 * @author 1z
 * @date 2022/1/26 20:26
 */
public class Apple {

    private Pear pear;

    public String getByName(String name) {
        return "test iFruit:" + name;
    }

    public Pear getPear() {
        return pear;
    }

    public void setPear(Pear pear) {
        this.pear = pear;
    }
}
