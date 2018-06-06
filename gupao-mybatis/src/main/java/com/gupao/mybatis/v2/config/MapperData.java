package com.gupao.mybatis.v2.config;

public class MapperData {
    private String sql;
    private Class clazz;

    public String getSql() {
        return sql;
    }

    public MapperData(String sql, Class clazz) {
        this.sql = sql;
        this.clazz = clazz;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
