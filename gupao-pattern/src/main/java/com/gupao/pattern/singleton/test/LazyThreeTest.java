package com.gupao.pattern.singleton.test;

import com.gupao.pattern.singleton.lazy.LazyThree;

import java.lang.reflect.Constructor;

public class LazyThreeTest {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = LazyThree.class;

        Constructor c = clazz.getDeclaredConstructor(null);

        c.setAccessible(true);

        Object o1 = c.newInstance();

        Object o2 = c.newInstance();

        System.out.println(o1 == o2);
    }
}
