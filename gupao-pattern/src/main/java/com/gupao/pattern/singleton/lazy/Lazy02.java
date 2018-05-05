package com.gupao.pattern.singleton.lazy;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-04 19:28
 * @version:
 **/
public class Lazy02 {

    private Lazy02(){}

    private static Lazy02 instance=null;

    public static synchronized Lazy02 getInstance(){
        if (instance == null) {
            instance = new Lazy02();
        }
        return instance;
    }
}
