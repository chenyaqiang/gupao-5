package com.gupao.mybatis.v2.executor;

import com.gupao.mybatis.v2.config.MapperData;

public interface Executor {

    <E> E query(MapperData mapperData, Object[] args);
}
