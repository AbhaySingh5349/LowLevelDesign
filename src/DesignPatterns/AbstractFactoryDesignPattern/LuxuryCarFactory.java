package DesignPatterns.AbstractFactoryDesignPattern;

public class LuxuryCarFactory implements AbstractFactory{
    @Override
    public Car getCarInstance(Integer price) {
        if(price <= 20000){
            return new LC1();
        }
        return new LC2();
    }
}
