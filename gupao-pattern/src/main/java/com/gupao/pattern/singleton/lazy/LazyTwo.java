package com.gupao.pattern.singleton.lazy;

public class LazyTwo {

    private static LazyTwo instance = null;

    private LazyTwo() {
    }

    public static synchronized LazyTwo getInstance() {
        if (instance == null) {
            instance = new LazyTwo();
        }
        return instance;
    }
}
