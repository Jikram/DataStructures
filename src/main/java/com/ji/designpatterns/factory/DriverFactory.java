package com.ji.designpatterns.factory;

public class DriverFactory {
    public static void main(String[] args) {
        ShapeFactory factory= new ShapeFactory();
        Shape type1 = factory.createShape("rectangle");
        System.out.println("Get rectangle  : " + type1.getShape());
        Shape type2 = factory.createShape("circle");
        System.out.println("Get circle : "+ type2.getShape());
    }

}
