package com.gupao.pattern.singleton.test;

import com.gupao.pattern.singleton.lazy.LazyOne;

import java.util.concurrent.CountDownLatch;

public class LazyOneTest {

    public static void main(String[] args) {

        int count = 1000;

        CountDownLatch latch = new CountDownLatch(count);

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 阻塞
                        // count = 0 就会释放所有的共享锁
                        // 万箭齐发
                        latch.await();

                        //必然会调用，可能会有很多线程同时去访问getInstance()
                        Object obj = LazyOne.getInstance();
                        System.out.println(System.currentTimeMillis() + ":" + obj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

            //每次启动一个线程，count --
            latch.countDown();
//            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start));
    }
}
