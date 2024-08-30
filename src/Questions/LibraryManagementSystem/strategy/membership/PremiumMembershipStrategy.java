package Questions.LibraryManagementSystem.strategy.membership;

import Questions.LibraryManagementSystem.enums.MemberType;

public class PremiumMembershipStrategy implements IMembership{
    private static final int MAX_ISSUED_BOOKS= 15;
    private static final int MAX_DAYS_HOLD_BOOK = 25;
    private static final int FINE_PER_DAY_PRICE = 1;
    private int discountRate = 5;
    private final MemberType memberType;

    public PremiumMembershipStrategy() {
        this.memberType = MemberType.PREMIUM;
    }

    @Override
    public int getMaxIssuedBooks() {
        return MAX_ISSUED_BOOKS;
    }

    @Override
    public int getDaysToHoldBook() {
        return MAX_DAYS_HOLD_BOOK;
    }

    @Override
    public int getFinePerDayPrice() {
        return FINE_PER_DAY_PRICE;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
