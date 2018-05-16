package com.gupao.pattern.template;

import java.sql.*;
import java.util.*;

public class JdbcTemplate {

    private static String url = "jdbc:mysql://10.10.38.200:3306/test";
    private static String user = "root";
    private static String password = "123456";


    private static volatile int capacity = 0;

    private static LinkedList<Connection> pool = new LinkedList<>();

    public JdbcTemplate() {
    }

    private Connection getConnection() throws Exception {
        if (pool.size() == 0) {
            createConnection();
        }

        Connection connection = pool.remove();
        capacity--;
        System.out.println("获取一个连接:" + connection + "----当前连接池容积：" + capacity);
        return connection;
    }

    private void createConnection() throws Exception {
        capacity++;
        Connection connection = DriverManager.getConnection(url, user, password);
        pool.add(connection);
        System.out.println("创建一个连接:" + connection + "----当前连接池容积：" + capacity);
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) throws Exception {

        //1、获取连接
        Connection conn = this.getConnection();
//        Connection conn = DriverManager.getConnection(url, user, password);


        //2、创建语句集
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //3、执行语句集，并且获得结果集
        ResultSet rs = this.executeQuery(pstmt, values);

        //4、解析语句集
        List<?> result = this.parseResultSet(rs, rowMapper);
//        while (rs.next()) {
//            System.out.println(rs.getInt("id") + "|" + rs.getString("name") + "|" + rs.getInt("age") + "\n");
//        }

        //5、关闭结果集
        this.closeResultSet(rs);
        //6、关闭语句集
        this.closeStatement(pstmt);
        //7、关闭连接
        this.closeConnection(conn);

        return result;
    }

    private ResultSet executeQuery(PreparedStatement pstmt, Object[] values) throws SQLException {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i, values[i]);
            }
        }

        return pstmt.executeQuery();
    }

    private List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rowMapper.mapRow(rs));
        }
        return list;
    }

    private void closeStatement(Statement stmt) throws Exception {
        stmt.close();
    }

    private void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }

    private void closeConnection(Connection conn) throws Exception {
        //放到连接池回收
        pool.add(conn);
        capacity++;
    }

    private void freeConnection(Connection conn) throws Exception {
        conn.close();
    }

}
