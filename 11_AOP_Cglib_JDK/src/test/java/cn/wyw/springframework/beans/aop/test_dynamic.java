package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.aop.AdvisedSupport;
import cn.wyw.springframework.aop.TargetSource;
import cn.wyw.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.wyw.springframework.aop.framework.Cglib2AopProxy;
import cn.wyw.springframework.aop.framework.JdkDynamicAopProxy;
import cn.wyw.springframework.beans.Fruit;
import org.junit.Test;

/**
 * @author 1z
 * @date 2022/1/26 20:31
 */
public class test_dynamic {

    @Test
    public void test(){
        Fruit fruit = new IFruit();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.wyw.springframework.beans.Fruit.*(..))"));
        advisedSupport.setTargetSource(new TargetSource(fruit));
        advisedSupport.setMethodInterceptor(new IFruitInterceptor());

        Object jdkFruit =  new JdkDynamicAopProxy(advisedSupport).getProxy();
        Fruit jdkFruit1 = (Fruit) jdkFruit;

        System.out.println(jdkFruit1.getByName("jdk proxy dd"));
        Fruit cglibIFruit = (Fruit) new Cglib2AopProxy(advisedSupport).getProxy();

        System.out.println(cglibIFruit.getByName("cglib proxy dd"));

    }
}
