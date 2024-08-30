package Questions.LibraryManagementSystem.strategy.price;

import Questions.LibraryManagementSystem.model.book.BookItem;

public class BasePriceDecorator implements IPriceDecorator{
    private final BookItem bookItem;

    public BasePriceDecorator(BookItem bookItem) {
        this.bookItem = bookItem;
    }

    @Override
    public double calculatePrice() {
        return bookItem.getPrice();
    }
}
