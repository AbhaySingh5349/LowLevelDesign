package DesignPatterns.AbstractFactoryDesignPattern;

public class EconomicCarFactory implements AbstractFactory{
    @Override
    public Car getCarInstance(Integer price) {
        if(price <= 10000){
            return new EC1();
        }
        return new EC2();
    }
}
