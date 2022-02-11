package cn.wyw.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * 属性
 * @author 1z
 * @date 2022/1/31 17:31
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    String value() ;
}
