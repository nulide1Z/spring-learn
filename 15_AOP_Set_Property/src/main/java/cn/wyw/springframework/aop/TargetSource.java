package cn.wyw.springframework.aop;

import cn.wyw.springframework.util.ClassUtil;

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

    /**
     * 判断是否由cglib 生成
     * @return  此类的接口
     */
    public Class<?>[] getTargetClass(){
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtil.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }


    public TargetSource(Object target) {
        this.target = target;
    }
}
