package com.gupao.pattern.singleton.lazy;

/**
 * 懒汉式单例
 * 特点：在外部类被调用的时候内部类才会被加载
 * 内部类一定是要在方法调用之前初始化
 * 巧妙地避免了线程安全问题
 *
 * @Author: wb
 * @CreateDate: 2018-05-04 19:29
 * @version:
 **/
public class Lazy03 {

    private boolean initialized = false;

    //默认使用Lazy03的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的

    private Lazy03() {
        synchronized (Lazy03.class) {
            if (initialized == false) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    //每一个关键字都不是多余的
    //static是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public static final Lazy03 getInstance() {
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder {
        private static final Lazy03 LAZY = new Lazy03();
    }
}
