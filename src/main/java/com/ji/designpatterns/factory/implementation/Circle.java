package com.ji.designpatterns.factory.implementation;

import com.ji.designpatterns.factory.Shape;

public class Circle implements Shape {
    @Override
    public String getShape() {
        return "Circle";
    }
}
