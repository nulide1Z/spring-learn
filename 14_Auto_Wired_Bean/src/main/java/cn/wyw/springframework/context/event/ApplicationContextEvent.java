package cn.wyw.springframework.context.event;


/**
 * 应用上下文事件
 * @author 1z
 * @date  2022/1/25 16:57
 **/
public  class ApplicationContextEvent extends ApplicationEvent{


    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }


    /**
    *  获取source
    * @return ApplicationEvent
    * @author 1z
    * @date   2022/1/25 19:16
    **/
    public final ApplicationEvent getApplicationContext() {
        return (ApplicationEvent) getSource();
    }
}
