package com.gupao.mybatis.demo;

import com.gupao.mybatis.bean.User;
import com.gupao.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Demo {

    public static SqlSession getSqlSession() throws FileNotFoundException{
        InputStream configFile = new FileInputStream("D:\\github\\gupao\\gupao-parent\\gupao-mybatis\\src\\main\\java\\com\\gupao\\mybatis\\demo\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws FileNotFoundException {

        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
    }
}
