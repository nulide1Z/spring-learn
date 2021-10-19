package cn.wyw.springfreamework.beans;

/**
 *
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:51
 */
public class Plate {

    private String name;

    private Apple apple;

    public void getApple(String name){
        System.out.println(apple.getByName(name));
    }

    public String getName() {
        return name;
    }

    public Apple getApple() {
        return apple;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }
}
