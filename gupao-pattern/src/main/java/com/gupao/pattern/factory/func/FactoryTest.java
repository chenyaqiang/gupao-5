package com.gupao.pattern.factory.func;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-05 9:53
 * @version:
 **/
public class FactoryTest {

    public static void main(String[] args) {
        Factory factory = new MengniuFactory();

        System.out.println(factory.getMilk());
    }
}
