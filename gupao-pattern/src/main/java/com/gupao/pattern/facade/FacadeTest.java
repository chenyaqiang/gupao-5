package com.gupao.pattern.facade;

public class FacadeTest {

    public static void main(String[] args) {

        Menu menu = new Menu();
        System.out.println("套餐A,两荤两素：" + menu.taocanA());

        Menu taocan2 = new Menu();
        System.out.println("套餐B,两荤一素：" + menu.taocanB());

    }
}
