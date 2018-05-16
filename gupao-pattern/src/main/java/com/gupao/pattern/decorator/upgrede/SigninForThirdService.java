package com.gupao.pattern.decorator.upgrede;

import com.gupao.pattern.decorator.old.ISigninService;
import com.gupao.pattern.decorator.old.ResultMsg;

public class SigninForThirdService implements ISigninForThirdService {

    private ISigninService service;

    public SigninForThirdService(ISigninService service){
        this.service = service;
    }


    @Override
    public ResultMsg loginForQQ(String openId) {
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法

        return loginForRegist(openId,null);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        this.register(username,null);
        return this.login(username,null);
    }

    @Override
    public ResultMsg register(String username, String password) {
        return service.register(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return service.login(username,password);
    }
}
