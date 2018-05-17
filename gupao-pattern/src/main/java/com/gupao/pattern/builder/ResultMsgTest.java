package com.gupao.pattern.builder;

public class ResultMsgTest {

    public static void main(String[] args) {

        System.out.println(new ResultMsgBuilder().setCode(200).setMsg("操作成功").setData(null).build());
    }
}
