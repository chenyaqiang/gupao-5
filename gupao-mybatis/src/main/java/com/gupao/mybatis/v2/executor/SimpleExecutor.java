package com.gupao.mybatis.v2.executor;

import com.gupao.mybatis.v2.config.Configuration;
import com.gupao.mybatis.v2.config.MapperData;
import com.gupao.mybatis.v2.statement.StatementHandler;

public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> E query(MapperData mapperData, Object[] args) {
        StatementHandler handler = new StatementHandler(configuration);
        return (E) handler.query(mapperData, args);
    }
}
