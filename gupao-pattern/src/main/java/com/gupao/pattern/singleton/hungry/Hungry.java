package com.gupao.pattern.singleton.hungry;

/**
 * 饿汉式单例
 *
 * 它是在类加载的时候就立即初始化，并且创建单例对象
 *
 * //优点：没有加任何的锁、执行效率比较高
 *
 * //缺点：类加载的时候就初始化,占用空间
 */
public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry(){}

    public Hungry getInstance(){
        return instance;
    }
}
