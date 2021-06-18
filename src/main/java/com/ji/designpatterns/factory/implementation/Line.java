package com.ji.designpatterns.factory.implementation;

import com.ji.designpatterns.factory.Shape;

public class Line implements Shape {

    @Override
    public String getShape() {
        return "Line";
    }
}
