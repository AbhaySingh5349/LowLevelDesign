package Questions.LibraryManagementSystem.strategy.book;

public class PaperbackBook implements IBook{
    private static final double DAILY_FINE = 2;
    private static final double BOOK_CHARGES = 15;

    @Override
    public double getPerDayFine() {
        return DAILY_FINE;
    }

    @Override
    public double getAdditionalCharges() {
        return BOOK_CHARGES;
    }
}
