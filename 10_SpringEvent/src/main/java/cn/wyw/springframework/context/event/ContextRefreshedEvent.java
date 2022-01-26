package cn.wyw.springframework.context.event;

/**
 * @desc
 * @author 1z
 * @date 2022/1/25 20:59
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
