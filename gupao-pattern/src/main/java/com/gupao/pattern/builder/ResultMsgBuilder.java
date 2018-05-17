package com.gupao.pattern.builder;

public class ResultMsgBuilder {

    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public ResultMsgBuilder setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultMsgBuilder setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultMsgBuilder setData(Object data) {
        this.data = data;
        return this;
    }

    public ResultMsg build(){
        return new ResultMsg(code,msg,data);
    }
}
