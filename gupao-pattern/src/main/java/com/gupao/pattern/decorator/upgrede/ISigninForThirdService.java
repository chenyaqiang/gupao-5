package com.gupao.pattern.decorator.upgrede;

import com.gupao.pattern.decorator.old.ISigninService;
import com.gupao.pattern.decorator.old.ResultMsg;

public interface ISigninForThirdService extends ISigninService {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String telphone, String code);

    ResultMsg loginForRegist(String username, String password);
}
