package DesignPatterns.AbstractFactoryDesignPattern;

public class AbstractFactoryProducer {
    public AbstractFactory getFactoryInstance(String value){
        if(value.equals("Economic")){
            return new EconomicCarFactory();
        }
        return new LuxuryCarFactory();
    }
}
