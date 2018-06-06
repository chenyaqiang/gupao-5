package com.gupao.mybatis.v2.session;

import com.gupao.mybatis.v2.config.Configuration;
import com.gupao.mybatis.v2.config.MapperData;
import com.gupao.mybatis.v2.executor.Executor;
import com.gupao.mybatis.v2.mapper.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;

public class SqlSession {

    private Configuration configuration;
    private Executor executor;

    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(MapperData mapperData, Object[] args) {
        List<T> list = selectList(mapperData, args);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public <E> E selectList(MapperData mapperData, Object[] args) {
        return (E) executor.query(mapperData, args);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new MapperProxy(this, clazz));
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }
}
