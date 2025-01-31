package com.github.fastjdbc;

import java.lang.reflect.Method;

/**
 * 
 * @Description: DaoListener
 * @Author: Fred Feng
 * @Date: 31/08/2024
 * @Version 1.0.0
 */
public interface DaoListener {

    default void beforeExecution(Method method, long startTime, String sql, Object[] args,
            Object handler) {}

    default void afterExecution(Method method, long startTime, String sql, Object[] args,
            Exception thrown, Object handler) {}

}
