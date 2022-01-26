package cn.wyw.springframework.beans;

import cn.wyw.springframework.context.ApplicationListener;
import cn.wyw.springframework.context.event.ContextCloseEvent;

/**
 * @author 1z
 * @date 2022/1/26 8:10
 */
public class ContextClosedEventListener implements ApplicationListener<ContextCloseEvent> {
    @Override
    public void onApplicationEvent(ContextCloseEvent event) {
        System.out.println("listen u close");
    }
}
