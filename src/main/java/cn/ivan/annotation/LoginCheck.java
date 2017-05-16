package cn.ivan.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 基于方法的运行注解，用于标注，拦不拦截
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 16:02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginCheck {
    boolean anonymity() default false;
}
