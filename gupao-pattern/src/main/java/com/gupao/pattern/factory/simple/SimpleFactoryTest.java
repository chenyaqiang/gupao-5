package com.gupao.pattern.factory.simple;

import com.gupao.pattern.factory.Yili;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-05 9:49
 * @version:
 **/
public class SimpleFactoryTest {


    public static void main(String[] args) {

        System.out.println(new Yili().getName());

        SimpleFactory factory = new SimpleFactory();

        System.out.println(factory.getMilk("伊利").getName());
    }
}
