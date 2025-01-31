package com.github.fastjdbc;

import java.lang.reflect.Proxy;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @Description: DaoProxyBeanFactory
 * @Author: Fred Feng
 * @Date: 31/08/2024
 * @Version 1.0.0
 */
public class DaoProxyBeanFactory<T> implements FactoryBean<T> {

    private final Class<T> interfaceClass;

    public DaoProxyBeanFactory(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private List<TypeHandler> typeHandlers;

    @SuppressWarnings("unchecked")
    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[] {interfaceClass},
                new DaoProxyBean<T>(dataSource, interfaceClass, typeHandlers));
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

}
