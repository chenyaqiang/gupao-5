package com.gupao.mybatis.v2.executor;

import com.gupao.mybatis.v2.config.Configuration;
import com.gupao.mybatis.v2.config.MapperData;

import java.util.HashMap;
import java.util.Map;

public class CachingExecutor implements Executor {

    private Configuration configuration;
    private SimpleExecutor delegate;

    private Map<String, Object> localCache = new HashMap();

    public CachingExecutor(SimpleExecutor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <E> E query(MapperData mapperData, Object[] args) {
        Object result = localCache.get(mapperData.getSql());
        if (null != result) {
            System.out.println("命中缓存");
            return (E) result;
        }
        result = delegate.query(mapperData, args);
        localCache.put(mapperData.getSql(), result);
        return (E) result;
    }
}
