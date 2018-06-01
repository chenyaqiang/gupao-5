package com.gupao.mybatis.v1;


import com.gupao.mybatis.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GPSimpleExecutor implements GPExecutor {


    @Override
    public <T> T query(String statement, String parameter) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<User> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.10.38.200:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");

            preparedStatement = connection.prepareStatement(statement);
            if (parameter != null) {
                preparedStatement.setString(1, parameter);
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                list.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T) list;

    }
}
