package com.gupao.mybatis.mapper;

import com.gupao.mybatis.bean.User;
import com.gupao.mybatis.v2.annotations.Mapper;
import com.gupao.mybatis.v2.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    @Select("select * from user where id = ?")
    User selectByPrimaryKey(Integer id);

    @Select("select * from user")
    List<User> selectList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}