package com.gupao.pattern.proxy.staticed;

public class Father {

    Person person;

    public Father(Person person) {
        this.person = person;
    }

    //目标对象的引用给拿到
    public void findLove() {
        System.out.println("根据你的要求物色");
        this.person.findLove();
        System.out.println("双方父母是不是同意");
    }

}
