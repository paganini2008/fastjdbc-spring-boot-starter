package com.github.fastjdbc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.github.fastjdbc.DaoListener;

/**
 * 
 * @Description: Get
 * @Author: Fred Feng
 * @Date: 31/01/2025
 * @Version 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Get {

    Base base() default @Base(opType = OpType.GET);

    String value();

    boolean javaType() default false;

    Class<? extends DaoListener>[] listeners() default {};

}
