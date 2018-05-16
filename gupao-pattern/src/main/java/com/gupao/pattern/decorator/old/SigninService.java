package com.gupao.pattern.decorator.old;

public class SigninService implements ISigninService {


    @Override
    public ResultMsg register(String username, String password) {
        return  new ResultMsg(200,"注册成功",new Member());
    }

    @Override
    public ResultMsg login(String username, String password) {
        return  new ResultMsg(200,"登录成功",new Member());
    }
}
