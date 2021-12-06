package cn.wyw.springframework.beans;

/**
 *
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:51
 */
public class Plate {

    private String name;

    private Apple apple;

    private String color;

    private String size;



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAppleName(){
        return apple.getByName(this.name)+" color:" +this.color +" size:" +size;
    }

    public void getAppleName(String name){
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
