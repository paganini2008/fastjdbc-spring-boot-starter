package com.github.fastjdbc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.github.fastjdbc.DaoListener;

/**
 * 
 * @Description: Update
 * @Author: Fred Feng
 * @Date: 31/08/2024
 * @Version 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Update {

    Base base() default @Base(opType = OpType.UPDATE);

    String value();

    Class<? extends DaoListener>[] listeners() default {};

}
