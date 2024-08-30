package Questions.LibraryManagementSystem.model.user;

import Questions.LibraryManagementSystem.model.book.BookItem;
import Questions.LibraryManagementSystem.service.FineManager;
import Questions.LibraryManagementSystem.strategy.payment.CashPaymentDetails;
import Questions.LibraryManagementSystem.strategy.payment.IPaymentMethod;
import Questions.LibraryManagementSystem.strategy.price.BasePriceDecorator;
import Questions.LibraryManagementSystem.strategy.price.DiscountPriceDecorator;
import Questions.LibraryManagementSystem.strategy.price.IPriceDecorator;

import java.util.Date;

public class Librarian extends User{
    private FineManager fineManager;

    public Librarian(String id, String name, FineManager fineManager) {
        super(id, name);
        this.fineManager = fineManager;
    }

    public Librarian(String id, String name) {
        super(id, name);
    }

    public void issueBook(BookItem bookItem, Member member){
        synchronized (bookItem){
            if(bookItem.isAvailable() && member.canIssueMoreBooks()){
                IPriceDecorator priceDecorator = new BasePriceDecorator(bookItem);
                priceDecorator = new DiscountPriceDecorator(priceDecorator, member.getMembership());

                double price = priceDecorator.calculatePrice();

                IPaymentMethod paymentMethod = member.getPaymentMethod();
                paymentMethod.processPayment(price, new CashPaymentDetails());

                member.issueBook(bookItem);
                bookItem.setIssueDate(new Date());
                bookItem.setAvailable(false);
            }
        }
    }

    public void acceptReturnedBook(BookItem bookItem, Member member){
        if(member.hasBook(bookItem)){
            double fine = fineManager.calculateFine(bookItem, member);

            IPaymentMethod paymentMethod = member.getPaymentMethod();
            paymentMethod.processPayment(fine, new CashPaymentDetails());

            bookItem.setIssueDate(null);
            bookItem.setAvailable(true);
            member.returnBook(bookItem);
        }
    }
}
