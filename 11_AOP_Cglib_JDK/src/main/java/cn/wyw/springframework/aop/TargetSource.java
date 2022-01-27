package cn.wyw.springframework.aop;

/**
 * 目标源
 * @author 1z
 * @date 2022/1/26 11:19
 */
public class TargetSource {

    private final Object target;

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getTargetClass(){
        return target.getClass().getInterfaces();
    }


    public TargetSource(Object target) {
        this.target = target;
    }
}
