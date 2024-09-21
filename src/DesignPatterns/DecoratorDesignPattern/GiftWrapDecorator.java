package DesignPatterns.DecoratorDesignPattern;

public class GiftWrapDecorator extends ProductDecorator {
    private double wrapCost = 5.00;

    public GiftWrapDecorator(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public String getName() {
        return decoratedProduct.getName() + " (Gift Wrapped)";
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice() + wrapCost;
    }
}