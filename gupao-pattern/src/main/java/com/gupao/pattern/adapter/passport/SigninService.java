package com.gupao.pattern.adapter.passport;

import com.gupao.pattern.adapter.Member;
import com.gupao.pattern.adapter.ResultMsg;

public class SigninService {

    /**
     * 注册方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password) {
        ResultMsg msg =  new ResultMsg(200, "注册成功", new Member());
        System.out.println(msg);
        return msg;
    }


    /**
     * 登录的方法
     *
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username, String password) {
        ResultMsg msg =  new ResultMsg(200, "登录成功", new Member());
        System.out.println(msg);
        return msg;
    }
}
