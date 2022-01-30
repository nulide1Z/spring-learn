package cn.wyw.springframework.aop;

/**
 *  切点通知者
 *  @author 1z
 *  @date 2022/1/29 19:28
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * 获取切点
     * @return 切点
     */
    Pointcut getPointcut();


}
