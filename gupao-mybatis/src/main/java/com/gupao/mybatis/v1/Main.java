package com.gupao.mybatis.v1;

import com.gupao.mybatis.bean.User;
import com.gupao.mybatis.mapper.UserMapper;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        GPSqlSession sqlSession = new GPSqlSession(new GPConfiguration(), new GPSimpleExecutor());
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        User user = userMapper.selectByPrimaryKey(1);
        List<User> user = userMapper.selectList();
        System.out.println(user);
    }
}
