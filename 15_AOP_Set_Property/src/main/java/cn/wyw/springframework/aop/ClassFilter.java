package cn.wyw.springframework.aop;

/**
 * class 过滤
 *
 * @author 1z
 * @date 2022/1/26 11:18
 */
public interface ClassFilter {

    /**
     * 匹配类
     * @param clazz 类
     * @return 是否匹配
     */
    Boolean matches(Class<?> clazz);
}
