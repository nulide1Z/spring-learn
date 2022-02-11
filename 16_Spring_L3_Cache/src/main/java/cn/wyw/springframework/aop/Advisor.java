package cn.wyw.springframework.aop;


import org.aopalliance.aop.Advice;

/**
 * 环绕者
 * @author 1z
 * @date 2022/1/29 19:24
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect
     * @return 返回一个环绕对象
     */
    Advice getAdvice();
}
