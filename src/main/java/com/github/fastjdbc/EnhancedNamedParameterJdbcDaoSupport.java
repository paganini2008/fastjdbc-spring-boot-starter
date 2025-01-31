package com.github.fastjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.lang.Nullable;

/**
 * 
 * @Description: EnhancedNamedParameterJdbcDaoSupport
 * @Author: Fred Feng
 * @Date: 31/08/2024
 * @Version 1.0.0
 */
public class EnhancedNamedParameterJdbcDaoSupport extends NamedParameterJdbcDaoSupport {

    @Nullable
    private EnhancedNamedParameterJdbcTemplate jdbcTemplate;

    @Override
    protected void initTemplateConfig() {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        if (jdbcTemplate != null) {
            this.jdbcTemplate = new EnhancedNamedParameterJdbcTemplate(jdbcTemplate);
        }
    }

    @Override
    public EnhancedNamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return this.jdbcTemplate;
    }

}
