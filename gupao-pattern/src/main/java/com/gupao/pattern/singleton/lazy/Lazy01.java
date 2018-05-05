package com.gupao.pattern.singleton.lazy;

/**
 * 懒汉式单例:在外部需要使用的时候才进行实例化
 *
 * @Author: wb
 * @CreateDate: 2018-05-04 19:24
 * @version:
 **/
public class Lazy01 {

    private Lazy01() {
    }

    //静态块，公共内存区域
    private static Lazy01 instance = null;

    public static Lazy01 getInstance() {
        //调用方法之前，先判断
        //如果没有初始化，将其进行初始化,并且赋值
        //将该实例缓存好
        if (instance == null) {
            //两个线程都会进入这个if里面
            instance = new Lazy01();
        }
        //如果已经初始化，直接返回之前已经保存好的结果

        return instance;
    }
}
