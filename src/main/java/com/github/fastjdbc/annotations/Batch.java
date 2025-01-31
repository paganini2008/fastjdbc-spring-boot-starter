package com.github.fastjdbc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.github.fastjdbc.DaoListener;

/**
 * 
 * @Description: Batch
 * @Author: Fred Feng
 * @Date: 12/01/2025
 * @Version 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Batch {

    Base base() default @Base(opType = OpType.BATCH);

    String value();

    Class<? extends DaoListener>[] listeners() default {};
}
