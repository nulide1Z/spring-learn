package cn.wyw.springframework.beans;

import cn.wyw.springframework.context.event.ApplicationContextEvent;

/**
 * @author 1z
 * @date 2022/1/26 1:07
 */
public class PlateEvent extends ApplicationContextEvent {

    private String title;

    private String desc;



    public PlateEvent(Object source, String title, String desc) {
        super(source);
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
