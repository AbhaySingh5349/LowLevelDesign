package Questions.LibraryManagementSystem.strategy.price;

public class GiftWrapDecorator implements IPriceDecorator{
    private final IPriceDecorator priceDecorator;
    private static final double GIFT_WRAP_COST = 5.00;

    public GiftWrapDecorator(IPriceDecorator priceDecorator) {
        this.priceDecorator = priceDecorator;
    }

    @Override
    public double calculatePrice() {
        return priceDecorator.calculatePrice() + GIFT_WRAP_COST;
    }
}
