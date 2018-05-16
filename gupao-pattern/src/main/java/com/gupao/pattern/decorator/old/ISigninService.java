package com.gupao.pattern.decorator.old;

public interface ISigninService {

    ResultMsg register(String username,String password);

    ResultMsg login(String username,String password);
}
