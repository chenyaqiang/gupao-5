package com.gupao.mybatis.v1;


import com.gupao.mybatis.mapper.UserMapper;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class GPConfiguration {

    public static final Map<String, Map<String, String>> mapperRegistry = new HashMap<>();

    static {
        Map<String, String> map = new HashMap<>();
        map.put("selectByPrimaryKey", "select * from user where id = ?");
        map.put("selectList", "select * from user");
        mapperRegistry.put(UserMapper.class.getName(), map);
    }

    public <T> T getMapper(Class<T> clazz, GPSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new GPMapperProxy(sqlSession));
    }

}
