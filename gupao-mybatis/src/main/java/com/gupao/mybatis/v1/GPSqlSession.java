package com.gupao.mybatis.v1;


import java.util.List;

public class GPSqlSession {

    private GPConfiguration configuration;
    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz, this);
    }

    public <T> T selectOne(String statement, String parameter) {
        List<T> list = this.selectList(statement, parameter);
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public <E> List<E> selectList(String statement) {
        return selectList(statement, null);
    }

    public <E> List<E> selectList(String statement, String parameter) {
        return executor.query(statement, parameter);
    }
}
