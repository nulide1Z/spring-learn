package cn.wyw.springframework.aop;

/**
 * 切点
 * @author 1z
 * @date 2022/1/26 11:19
 */
public interface Pointcut {

    /**
     * 获取类过滤器
     *
     * @return ClassFilter
     * @author 1z
     * @date 2022/1/26 11:22
     */
    ClassFilter getClassFilter();

    /**
     * 获取方法匹配器
     *
     * @return MethodMatcher
     * @author 1z
     * @date 2022/1/26 11:22
     */
    MethodMatcher getMethodMatcher();
}
