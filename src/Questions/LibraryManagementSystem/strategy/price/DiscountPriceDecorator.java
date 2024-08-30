package Questions.LibraryManagementSystem.strategy.price;

import Questions.LibraryManagementSystem.strategy.membership.IMembership;

public class DiscountPriceDecorator implements IPriceDecorator{
    private final IPriceDecorator priceDecorator;
    private final IMembership membership;

    public DiscountPriceDecorator(IPriceDecorator priceDecorator, IMembership membership) {
        this.priceDecorator = priceDecorator;
        this.membership = membership;
    }

    @Override
    public double calculatePrice() {
        double price = priceDecorator.calculatePrice();
        return price * (1 - membership.getDiscountRate());
    }
}
