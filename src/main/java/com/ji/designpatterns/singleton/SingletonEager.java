package com.ji.designpatterns.singleton;
// Eager Loading
public class SingletonEager {
    private static SingletonEager obj = new SingletonEager();
    private SingletonEager() {}
    public static SingletonEager getInstance() {
        return obj;
    }
}
