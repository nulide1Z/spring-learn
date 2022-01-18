package cn.wyw.springframework.beans;

import cn.wyw.springframework.beans.factory.DisposableBean;
import cn.wyw.springframework.beans.factory.InitializingBean;

/**
 *
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/19 14:51
 */
public class Plate implements InitializingBean, DisposableBean {

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

    @Override
    public void destroy() throws Exception {
        System.out.println("invoke plate destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke plate afterPropertiesSet method");
    }
}
