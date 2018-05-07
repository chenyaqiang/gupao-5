package com.gupao.pattern.singleton.lazy;

public class LazyOne {

    private static LazyOne instance = null;

    private LazyOne() {
    }

    public static LazyOne getInstance() {
        if (instance == null) {
            instance = new LazyOne();
        }
        return instance;
    }
}
