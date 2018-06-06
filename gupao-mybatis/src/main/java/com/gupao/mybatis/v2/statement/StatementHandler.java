package com.gupao.mybatis.v2.statement;

import com.gupao.mybatis.v2.config.Configuration;
import com.gupao.mybatis.v2.config.MapperData;
import com.gupao.mybatis.v2.config.MapperRegistry;
import com.gupao.mybatis.v2.result.ResultSetHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementHandler {

    private Configuration configuration;

    private final ResultSetHandler resultSetHandler;

    public StatementHandler(Configuration configuration) {
        this.configuration = configuration;
        resultSetHandler = new ResultSetHandler(configuration);
    }


    public <E> E query(MapperData mapperData, Object[] args) {
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(mapperData.getSql());
            if (null != args) {
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof String) {
                        pstmt.setString(i + 1, args[i].toString());
                    }
                    if (args[i] instanceof Integer) {
                        pstmt.setInt(i + 1, Integer.parseInt(String.valueOf(args[i])));
                    }
                }
            }
            pstmt.execute();
            return (E) resultSetHandler.handle(pstmt.getResultSet(), mapperData.getClazz());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://10.10.38.200:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
