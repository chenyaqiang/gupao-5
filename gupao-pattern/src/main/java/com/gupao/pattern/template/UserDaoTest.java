package com.gupao.pattern.template;

import com.gupao.pattern.template.dao.UserDao;

public class UserDaoTest {

    private static String sql = "select * from user";

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            UserDao userDao = new UserDao();
            userDao.query(sql, null);
        }
    }
}
