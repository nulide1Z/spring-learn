package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.beans.Fruit;

import java.util.Random;

/**
 * @author 1z
 * @date 2022/1/26 20:26
 */
public class IFruit implements Fruit {

    @Override
    public String getByName(String name) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test iFruit";
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
}
