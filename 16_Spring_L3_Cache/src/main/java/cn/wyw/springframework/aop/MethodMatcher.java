package cn.wyw.springframework.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配器
 *
 * @author 1z
 * @date 2022/1/26 11:19
 */
public interface MethodMatcher {

    /**
     * 匹配
     *
     * @param method 方法
     * @param clazz 类
     * @return Boolean 布尔值
     * @author 1z
     * @date 2022/1/26 15:32
     */
    Boolean matches(Method method, Class<?> clazz);
}
