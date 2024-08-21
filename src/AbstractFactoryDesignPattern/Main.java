package AbstractFactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
        AbstractFactory abstractFactory = abstractFactoryProducer.getFactoryInstance("Economic");

        Car economicCar = abstractFactory.getCarInstance(15000);
        System.out.println("Top Speed: " + economicCar.getTopSpeed());
    }
}
