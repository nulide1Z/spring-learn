package cn.wyw.springframework.context.event;

/**
 * @desc
 * @author 1z
 * @date 2022/1/25$ 20:57$
 */
public class ContextCloseEvent extends ApplicationContextEvent{

    public ContextCloseEvent(Object source) {
        super(source);
    }


}
