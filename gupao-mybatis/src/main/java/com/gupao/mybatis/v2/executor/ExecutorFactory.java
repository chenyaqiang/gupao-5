package com.gupao.mybatis.v2.executor;

import com.gupao.mybatis.v2.config.Configuration;

public class ExecutorFactory {
    private static final String CACHING = "CACHING";
    private static final String SIMPLE = "SIMPLE";


    public static Executor get(Configuration configuration) {
        return get("SIMPLE", configuration);
    }

    public static Executor get(String key, Configuration configuration) {
        if (CACHING.equalsIgnoreCase(key)) {
            return new CachingExecutor(new SimpleExecutor(configuration));
        } else if (SIMPLE.equalsIgnoreCase(key)) {
            return new SimpleExecutor(configuration);
        } else {
            throw new RuntimeException("no executor found");
        }
    }


    public enum ExecutorType {
        CACHING, SIMPLE;
    }

}
