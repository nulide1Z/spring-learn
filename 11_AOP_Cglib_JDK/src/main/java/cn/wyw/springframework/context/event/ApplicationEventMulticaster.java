package cn.wyw.springframework.context.event;

import cn.wyw.springframework.context.ApplicationListener;

/**
 *  应用事件广播器
 * @author 1z
 * @date 2022/1/25 21:09
 */
public interface ApplicationEventMulticaster {


    /**
     *
     * 添加监听器
     * @param listener 监听器
     * @author 1z
     * @date 2022/1/25 21:50
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     *
     * 删除监听器
     * @param listener 监听器
     * @author 1z
     * @date 2022/1/25 21:55
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     *
     *  将事件广播给监听器
     * @param event 事件
     * @author 1z
     * @date 2022/1/25 21:56
     */
    void multicasterListener(ApplicationEvent event);

}
