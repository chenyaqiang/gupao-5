package com.gupao.mybatis.v2.config;


import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {

    public static final Map<String, MapperData> methodSqlMapping = new HashMap<>();

    public MapperData get(String nameSpace) {
        return methodSqlMapping.get(nameSpace);
    }
}
