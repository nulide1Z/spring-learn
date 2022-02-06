package cn.wyw.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * 范围
 * @author 1z
 * @date 2022/1/30 22:25
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";

}
