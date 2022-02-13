package cn.wyw.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * 预选赛
 * @author 1z
 * @date 2022/1/31 17:31
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";
}
