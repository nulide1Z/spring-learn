package cn.wyw.springframework.beans;



import cn.wyw.springframework.context.ApplicationListener;
import cn.wyw.springframework.context.event.ContextRefreshedEvent;

import java.util.EventListener;

/**
 * @author 1z
 * @date 2022/1/26 1:18
 */
public class ContextRefreshEventListener implements ApplicationListener<ContextRefreshedEvent>,EventListener {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("listen u refreshed");

    }
}
