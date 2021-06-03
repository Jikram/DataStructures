package com.ji.designpatterns.factory;

import com.ji.designpatterns.factory.implementation.*;

public class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equals("circle")) return new Circle();
        else if (shapeType.equals("line")) return new Line();
        else if (shapeType.equals("rectangle")) return new Rectangle();
        else if (shapeType.equals("square")) return new Square();
        else if (shapeType.equals("triangle")) return new Triangle();
        else return null;
    }
}
