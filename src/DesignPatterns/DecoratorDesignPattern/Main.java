package DesignPatterns.DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Product basicProduct = new Product("Smartphone", 299.99);

        Product giftWrappedProduct = new GiftWrapDecorator(basicProduct);
        Product discountedProduct = new DiscountCouponDecorator(giftWrappedProduct, 10); // 10% discount

        System.out.println("Product Name: " + discountedProduct.getName());
        System.out.println("Product Price: $" + discountedProduct.getPrice());
    }
}

