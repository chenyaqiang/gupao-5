package com.gupao.mybatis.v2;

import com.gupao.mybatis.bean.User;
import com.gupao.mybatis.mapper.UserMapper;
import com.gupao.mybatis.v2.config.Configuration;
import com.gupao.mybatis.v2.executor.ExecutorFactory;
import com.gupao.mybatis.v2.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class BootStrap {

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        configuration.build("com.gupao.mybatis.mapper");

        SqlSession sqlSession = new SqlSession(configuration,
                ExecutorFactory.get(ExecutorFactory.ExecutorType.CACHING.name(), configuration));

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
//        List<User> user = userMapper.selectList();
        System.out.println(user);
    }
}
