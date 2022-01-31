package cn.wyw.springframework.stereotype;

import java.lang.annotation.*;

/**
 * 组件注解
 *
 * @author 1z
 * @date 2022/1/30 22:03
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
