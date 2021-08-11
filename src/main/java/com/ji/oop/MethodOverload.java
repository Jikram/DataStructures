package com.ji.oop;

public class MethodOverload {
    public static void main(String[] args) {
        getColor("purple");
        getColor((Object) "red");
        getColor(" ");
        getColor(null);
        getColor("blue", "green");
    }

    public static String getColor(String name) {
        System.out.println("get color with string param :" + name);
        return name;
    }

    public static String getColor(String name1, String name2) {
        System.out.println("get two color with string param :" + name1 + " " + name2);
        return name1 + " " + name2;
    }

    public static String getColor(Object name) {
        System.out.println("get color with object param :" + name);
        return ((String) name);
    }

}
