package cn.wyw.springframework.aop.aspectj;

import cn.wyw.springframework.aop.Pointcut;
import cn.wyw.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * Aspectj 表达式切入点顾问
 * @author 1z
 * @date 2022/1/29 19:21
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {


    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;

    /**
     * 具体拦截方法
     */
    private Advice advice;

    /**
     * 表达式
     */
    private String expression;

    @Override
    public Pointcut getPointcut() {
        if (expression != null){
            return new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setPointcut(AspectJExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
