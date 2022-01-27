package cn.wyw.springframework.context.event;

import java.util.EventObject;

/**
 *
 * 定义事件
 * @author 1z
 * @date 2022/1/26 1:38
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

}
