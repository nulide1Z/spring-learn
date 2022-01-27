package cn.wyw.springframework.beans;

import cn.wyw.springframework.context.ApplicationListener;

/**
 * @author 1z
 * @date 2022/1/26 1:08
 */
public class PlateListener implements ApplicationListener<PlateEvent> {


    @Override
    public void onApplicationEvent(PlateEvent event) {
        System.out.println("listen u now event: " +event.getTitle() + " and " + event.getDesc());
    }
}
