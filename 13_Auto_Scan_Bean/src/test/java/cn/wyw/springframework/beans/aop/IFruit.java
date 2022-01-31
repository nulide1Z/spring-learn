package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.stereotype.Component;

import java.util.Random;

/**
 *
 * @author 1z
 * @date 2022/1/26 20:26
 */
@Component(value = "iFruit")
public class IFruit implements Fruit {

    private String token;

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
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "register：" + name + " success！";
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
}
