package com.gupao.mybatis.v2.config;


import com.gupao.mybatis.bean.User;
import com.gupao.mybatis.mapper.UserMapper;
import com.gupao.mybatis.v2.annotations.Select;
import com.gupao.mybatis.v2.utils.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

public class Configuration {

    private MapperRegistry mapperRegistory = new MapperRegistry();
    private String scanPath;

    public Configuration() {

    }

    public void build(String scanPath) {
        this.scanPath = scanPath;
        if (StringUtils.isEmpty(scanPath)) {
            throw new RuntimeException("scanPath is empty");
        }

        Set<Class<?>> clazzs = ClassUtils.getClasses("com.gupao.mybatis.mapper");
        for (Class<?> clazz : clazzs) {
            // 获取类上的注解
            Annotation[] annos = clazz.getAnnotations();
            for (Annotation clazzAnno : annos) {
                if (clazzAnno.annotationType().getSimpleName().equals("Mapper")) {
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method method : methods) {
                        Annotation[] annotations = method.getDeclaredAnnotations();
                        for (Annotation methodAnno : annotations) {
                            if (methodAnno.annotationType().getSimpleName().equals("Select")) {
                                Select selectAnno = (Select) methodAnno;
                                String key = scanPath + "." + clazz.getSimpleName() + "." + method.getName();
                                //此处应该传一个实体类和数据库的映射关系
                                MapperData mapperData = new MapperData(selectAnno.value(), User.class);
                                mapperRegistory.methodSqlMapping.put(key, mapperData);
                            }
                        }
                    }
                }
            }
        }
    }

    public MapperRegistry getMapperRegistory() {
        return mapperRegistory;
    }


    public String getScanPath() {
        return scanPath;
    }

    public void setScanPath(String scanPath) {
        this.scanPath = scanPath;
    }


    public static void main(String[] args) throws NoSuchMethodException {
        Method method = UserMapper.class.getMethod("selectList");
        System.out.println(method);
    }
}
