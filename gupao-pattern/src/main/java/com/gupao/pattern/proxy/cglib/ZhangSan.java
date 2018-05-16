package com.gupao.pattern.proxy.cglib;

import com.gupao.pattern.proxy.staticed.Person;

/**
 * Created by Tom on 2018/3/10.
 */
public class ZhangSan implements Person {

    @Override
    public void findLove(){
        System.out.println("肤白貌美大长腿");
    }

    @Override
    public void findJob() {

    }

}
