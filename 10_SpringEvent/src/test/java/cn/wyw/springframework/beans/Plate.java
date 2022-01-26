package cn.wyw.springframework.beans;

/**
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:51
 */
public class Plate  {

    private String name;

    private Fruit fruitProxy;

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

    public String getAppleName() {
        return fruitProxy.getByName(this.name) + " color:" + this.color + " size:" + size;
    }

    public void getAppleName(String name) {
        System.out.println(fruitProxy.getByName(name));
    }

    public String getName() {
        return name;
    }

    public Fruit getFruitProxy() {
        return fruitProxy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFruitProxy(Fruit fruitProxy) {
        this.fruitProxy = fruitProxy;
    }



}
