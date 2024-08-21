package FactoryDesignPattern;

public class ShapeInstanceFactory {
    public Shape getShapeInstance(String value){
        if(value.equals("Circle")){
            return new Circle();
        }else if(value.equals("Rectangle")){
            return new Rectangle();
        }
        return null;
    }
}
