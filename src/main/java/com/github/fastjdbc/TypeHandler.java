package com.github.fastjdbc;

/**
 * 
 * @Description: TypeHandler
 * @Author: Fred Feng
 * @Date: 14/01/2025
 * @Version 1.0.0
 */
public interface TypeHandler {

    default boolean support(Object originalValue) {
        return false;
    }

    Object convertValue(Object originalValue);

}
