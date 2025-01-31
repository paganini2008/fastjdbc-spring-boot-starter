package com.github.fastjdbc;

import java.sql.SQLException;

/**
 * 
 * @Description: NoGeneratedKeyException
 * @Author: Fred Feng
 * @Date: 01/02/2025
 * @Version 1.0.0
 */
public class NoGeneratedKeyException extends SQLException {

    private static final long serialVersionUID = -1903213976808407478L;

    public NoGeneratedKeyException(String sql) {
        super(sql);
    }

}
