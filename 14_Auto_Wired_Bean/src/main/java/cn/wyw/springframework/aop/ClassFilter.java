package cn.wyw.springframework.aop;

/**
 * class 过滤
 *
 * @author 1z
 * @date 2022/1/26 11:18
 */
public interface ClassFilter {

    Boolean matches(Class<?> clazz);
}
