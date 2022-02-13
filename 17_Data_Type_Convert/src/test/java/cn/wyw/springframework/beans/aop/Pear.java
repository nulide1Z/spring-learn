package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.stereotype.Component;

/**
 * @author 1z
 * @date 2022/2/1 15:05
 */
public class Pear {

    private Apple apple;

    private Fruit fruit;

    public String getIFruit(String name){
        return "代理fruit执行:" + fruit.getFruitName("fei fei");
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
}
