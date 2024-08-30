package Questions.LibraryManagementSystem.strategy.membership;

import Questions.LibraryManagementSystem.enums.MemberType;

public class NormalMembershipStrategy implements IMembership{
    private static final int MAX_ISSUED_BOOKS= 10;
    private static final int MAX_DAYS_HOLD_BOOK = 15;
    private static final int FINE_PER_DAY_PRICE = 2;
    private int discountRate = 5;
    private final MemberType memberType;

    public NormalMembershipStrategy() {
        this.memberType = MemberType.NORMAL;
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

    public int getDiscountRate() {
        return discountRate;
    }

    @Override
    public MemberType getMemberType() {
        return memberType;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
