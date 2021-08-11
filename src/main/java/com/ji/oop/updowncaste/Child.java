package com.ji.oop.updowncaste;

public class Child extends UpDownCaste {
    public int id;
    public void getName() {
        System.out.println("method from child class");
    }
    public void getAge(){
        System.out.println("age of child is 15");
    }
    public void getHeight(){
        System.out.println("height of the child");
    }
}

