package com.gupao.pattern.proxy.jdk;

import com.gupao.pattern.proxy.staticed.Person;

public class XieMu implements Person {


    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("胸大，6块腹肌");
    }

    @Override
    public void findJob() {
        System.out.println("月薪20K-50k");
        System.out.println("找工作");
    }
}
