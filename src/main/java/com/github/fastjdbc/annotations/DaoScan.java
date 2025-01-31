package com.github.fastjdbc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import com.github.fastjdbc.DaoScannerRegistrar;

/**
 * 
 * @Description: DaoScan
 * @Author: Fred Feng
 * @Date: 31/08/2024
 * @Version 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({DaoScannerRegistrar.class})
public @interface DaoScan {

    String[] basePackages();

}
