package DesignPatterns.DecoratorDesignPattern;

public abstract class ProductDecorator extends Product {
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        super(decoratedProduct.getName(), decoratedProduct.getPrice());
        this.decoratedProduct = decoratedProduct;
    }

    @Override
    public abstract String getName();
    @Override
    public abstract double getPrice();
}
