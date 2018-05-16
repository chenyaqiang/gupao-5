package com.gupao.pattern.template.dao;

import com.gupao.pattern.template.JdbcTemplate;
import com.gupao.pattern.template.RowMapper;
import com.gupao.pattern.template.entity.User;

import java.sql.ResultSet;
import java.util.List;


public class UserDao {

    //为什么不继承，主要是为了解耦
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();


    public List<?> query(String sql, Object[] values) throws Exception {
        return jdbcTemplate.executeQuery(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws Exception {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        }, values);
    }


}
