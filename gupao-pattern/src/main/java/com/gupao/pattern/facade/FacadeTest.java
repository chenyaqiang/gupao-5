package com.gupao.pattern.facade;

public class FacadeTest {

    public static void main(String[] args) {

        Menu taocan1 = new Menu();
        System.out.println("两荤两素：" + taocan1.twoMeetTwoVegetable());

        Menu taocan2 = new Menu();
        System.out.println("两荤一素：" + taocan2.twoMeetOneVegetable());

    }
}
