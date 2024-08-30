package Questions.LibraryManagementSystem.strategy.membership;

import Questions.LibraryManagementSystem.enums.MemberType;

public interface IMembership {
    int getMaxIssuedBooks();
    int getDaysToHoldBook();
    int getFinePerDayPrice();
    int getDiscountRate();
    MemberType getMemberType();
}
