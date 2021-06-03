package com.ji.designpatterns.factory.implementation;

import com.ji.designpatterns.factory.Shape;

public class Triangle implements Shape {
    @Override
    public String getShape() {
        return "Triangle";
    }
}
