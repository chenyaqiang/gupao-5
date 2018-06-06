package com.gupao.mybatis.v2.mapper;

import com.gupao.mybatis.v2.config.MapperData;
import com.gupao.mybatis.v2.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

public class MapperProxy<T> implements InvocationHandler {

    private final SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> clazz) {
        this.sqlSession = sqlSession;
        this.mapperInterface = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperData mapperData =
                sqlSession.getConfiguration()
                        .getMapperRegistory()
                        .get(method.getDeclaringClass().getName() + "." + method.getName());

        if (null != mapperData) {
            if (method.getReturnType().isArray() || Collection.class.isAssignableFrom(method.getReturnType())) {
                return sqlSession.selectList(mapperData, args);
            } else {
                return sqlSession.selectOne(mapperData, args);
            }
        }
        return method.invoke(proxy, args);
    }
}
