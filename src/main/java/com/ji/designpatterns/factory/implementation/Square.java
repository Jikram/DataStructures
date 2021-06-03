package com.ji.designpatterns.factory.implementation;

import com.ji.designpatterns.factory.Shape;

public class Square implements Shape {


    @Override
    public String getShape() {
        return "square object";
    }
}
