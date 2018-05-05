package com.gupao.pattern.singleton.test;

import com.gupao.pattern.singleton.lazy.Lazy02;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-05-04 19:35
 * @version:
 **/
public class Lazy02Test {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 200000000; i++) {
            Object obj = Lazy02.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
