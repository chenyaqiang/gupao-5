package com.gupao.pattern.singleton.test;

import com.gupao.pattern.singleton.lazy.Lazy03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-04 19:35
 * @version:
 **/
public class Lazy03Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class<?> clazz = Lazy03.class;

        //通过反射拿到私有的构造方法
        Constructor c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);

        //暴力初始化
        Object o1 = c.newInstance();

        //调用了两次构造方法，相当于new了两次
        //犯了原则性问题，
        Object o2 = c.newInstance();

        System.out.println(o1 == o2);


    }
}
