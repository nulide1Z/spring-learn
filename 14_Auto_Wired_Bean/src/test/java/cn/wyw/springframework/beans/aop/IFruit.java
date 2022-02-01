package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.beans.factory.annotation.AutoWired;
import cn.wyw.springframework.beans.factory.annotation.Value;
import cn.wyw.springframework.stereotype.Component;

import java.util.Random;

/**
 *
 * @author 1z
 * @date 2022/1/26 20:26
 */
@Component(value = "iFruit")
public class IFruit implements Fruit {

    @Value("${token}")
    private String token;

    @AutoWired
    private Pear pear;

    @Override
    public String getByName(String name) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test iFruit:" + name;
    }
    @Override
    public String register(String name) {
        return "register：" + pear.getPear(name) + " success！" + "token: " + token;
    }

    @Override
    public String toString() {
        return "iFruit" + token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Pear getPear() {
        return pear;
    }

    public void setPear(Pear pear) {
        this.pear = pear;
    }
}
