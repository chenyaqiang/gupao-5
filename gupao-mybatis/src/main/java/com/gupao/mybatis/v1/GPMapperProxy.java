package com.gupao.mybatis.v1;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;


public class GPMapperProxy implements InvocationHandler {

    private final GPSqlSession sqlSession;

    public GPMapperProxy(GPSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {


        Map methodMapper = GPConfiguration.mapperRegistry.get(method.getDeclaringClass().getName());
        if (methodMapper != null) {
            String sql = (String) methodMapper.get(method.getName());

            if (method.getReturnType().isArray() || Collection.class.isAssignableFrom(method.getReturnType())) {
                if (args==null){
                    return sqlSession.selectList(sql);
                }else{
                    return sqlSession.selectList(sql, String.valueOf(args[0]));
                }
            } else {
                return sqlSession.selectOne(sql, String.valueOf(args[0]));
            }
        }

        return method.invoke(this, args);
    }
}
