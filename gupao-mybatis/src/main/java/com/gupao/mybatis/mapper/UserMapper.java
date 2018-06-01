package com.gupao.mybatis.mapper;

import com.gupao.mybatis.bean.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}