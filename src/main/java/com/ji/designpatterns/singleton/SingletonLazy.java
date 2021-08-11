package com.ji.designpatterns.singleton;

// lazy loading
public class SingletonLazy {
    private static SingletonLazy obj;

    private SingletonLazy() {
    }

    // For thread safety we can make method or block of code synchronized
    public synchronized static SingletonLazy getInstance() {
        if (obj == null) {
            obj = new SingletonLazy();
        }
        return obj;
    }
}
