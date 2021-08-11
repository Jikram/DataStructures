package com.ji.designpatterns.singleton;

public class SingletonDriver {
    public static void main(String[] args) {

        SingletonLazy instance1 = SingletonLazy.getInstance();
        SingletonLazy instance = SingletonLazy.getInstance();


    }


}
