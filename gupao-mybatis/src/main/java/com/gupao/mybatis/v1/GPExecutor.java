package com.gupao.mybatis.v1;


public interface GPExecutor {

    <T> T query(String statement, String parameter);

}
