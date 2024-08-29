package DesignPatterns.FactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        ShapeInstanceFactory shapeInstanceFactory = new ShapeInstanceFactory();
        Shape circle = shapeInstanceFactory.getShapeInstance("Circle");
        Shape rectangle = shapeInstanceFactory.getShapeInstance("Rectangle");

        circle.draw();
        rectangle.draw();
    }
}
