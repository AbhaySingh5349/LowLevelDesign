package DecoratorDesignPattern;

public class DiscountCouponDecorator extends ProductDecorator {
    private double discountPercent;

    public DiscountCouponDecorator(Product decoratedProduct, double discountPercent) {
        super(decoratedProduct);
        this.discountPercent = discountPercent;
    }

    @Override
    public String getName() {
        return decoratedProduct.getName() + " (Discounted)";
    }

    @Override
    public double getPrice() {
        double originalPrice = decoratedProduct.getPrice();
        double discountAmount = originalPrice * (discountPercent / 100);
        return originalPrice - discountAmount;
    }
}
