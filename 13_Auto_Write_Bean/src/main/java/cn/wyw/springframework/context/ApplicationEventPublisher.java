package cn.wyw.springframework.context;

import cn.wyw.springframework.context.event.ApplicationEvent;

/**
 * 应用事件发布者
 * @author 1z
 * @date 2022/1/26 0:44
 */
public interface ApplicationEventPublisher {

    /**
     * 发布事件
     *
     * @param event 事件
     * @author 1z
     * @date 2022/1/26 0:45
     */
    void publishEvent(ApplicationEvent event);
}
