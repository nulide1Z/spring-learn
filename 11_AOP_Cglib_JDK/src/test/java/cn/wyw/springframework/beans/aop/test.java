package cn.wyw.springframework.beans.aop;

import cn.wyw.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.wyw.springframework.beans.Plate;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 1z
 * @date 2022/1/26 16:53
 */
public class test {

    @Test
    public void test_aop() throws NoSuchMethodException{
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut("execution(* cn.wyw.springframework.beans.Plate.*(..))");
        Class<Plate> plateClass = Plate.class;
        Method getAppleName = plateClass.getDeclaredMethod("getAppleName");

        System.out.println( aspectJExpressionPointcut.matches(plateClass));
        System.out.println( aspectJExpressionPointcut.matches(getAppleName, plateClass));
    }
}
