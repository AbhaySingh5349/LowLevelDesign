package Questions.LibraryManagementSystem.strategy.book;

public class Ebook implements IBook{
    private static final double DAILY_FINE = 5;
    private static final double BOOK_CHARGES = 20;

    @Override
    public double getPerDayFine() {
        return DAILY_FINE;
    }

    @Override
    public double getAdditionalCharges() {
        return BOOK_CHARGES;
    }
}
