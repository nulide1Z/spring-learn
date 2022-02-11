package cn.wyw.springframework.context;

import cn.wyw.springframework.context.event.ApplicationContextEvent;
import cn.wyw.springframework.context.event.ApplicationEvent;

import java.util.EventListener;

/**
 * 应用监听器
 * @author 1z
 * @date 2022/1/25 22:10
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     *
     * listener invoke event
     * @param event event
     * @author 1z
     * @date 2022/1/26 1:02
     */
    void onApplicationEvent(E event);
}
