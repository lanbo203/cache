package com.example.demo.provider.annotation;

import java.lang.annotation.*;

/**
 * Created by yexin on 2017/9/1.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CacheMsg {

    String key() default "";

    String opt() default "";

    Class<?> pojo() ;
}
