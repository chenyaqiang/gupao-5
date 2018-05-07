package com.gupao.pattern.singleton.lazy;


public class LazyThree {

    private boolean initialized = false;

    //防止反序列化
    private LazyThree() {
        synchronized (LazyThree.class) {
            if (initialized == false) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    public static final LazyThree getInstance() {
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyThree LAZY = new LazyThree();
    }
}
