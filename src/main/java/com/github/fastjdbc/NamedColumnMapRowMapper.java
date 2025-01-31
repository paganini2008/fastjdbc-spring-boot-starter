package com.github.fastjdbc;

import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * 
 * @Description: NamedColumnMapRowMapper
 * @Author: Fred Feng
 * @Date: 31/08/2024
 * @Version 1.0.0
 */
public class NamedColumnMapRowMapper extends ColumnMapRowMapper {

    @Override
    protected String getColumnKey(String columnName) {
        String name = super.getColumnKey(columnName);
        return JdbcUtils.convertUnderscoreNameToPropertyName(name);
    }

}
