package com.gupao.pattern.factory.abstr;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-05 10:01
 * @version:
 **/
public class AbstractFactoryTest {

    public static void main(String[] args) {
        MilkFactory factory = new MilkFactory();

        System.out.println(factory.getMengniu());
        System.out.println(factory.getYili());
    }
}
