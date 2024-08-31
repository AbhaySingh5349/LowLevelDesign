package Questions.LibraryManagementSystem.model.user;

import Questions.LibraryManagementSystem.model.book.BookItem;
import Questions.LibraryManagementSystem.strategy.membership.IMembership;
import Questions.LibraryManagementSystem.strategy.observer.IBookObserver;
import Questions.LibraryManagementSystem.strategy.payment.IPaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Member extends User implements IBookObserver {
    List<BookItem> issuedBooks;
    private final IMembership membership;
    private IPaymentMethod paymentMethod;

    public Member(String id, String name, IMembership membership) {
        super(id, name);
        this.issuedBooks = new ArrayList<>();
        this.membership = membership;
    }

    public List<BookItem> getIssuedBooks() {
        return issuedBooks;
    }

    public boolean canIssueMoreBooks(){
        return membership.getMaxIssuedBooks() < issuedBooks.size();
    }

    public void issueBook(BookItem bookItem){
        synchronized (this){
            issuedBooks.add(bookItem);
        }
    }

    public boolean hasBook(BookItem bookItem){
        return issuedBooks.contains(bookItem);
    }

    public int getDaysToHoldBook(){
        return membership.getDaysToHoldBook();
    }

    public void returnBook(BookItem bookItem){
        synchronized (this){
            issuedBooks.remove(bookItem);
        }
    }

    public IMembership getMembership() {
        return membership;
    }

    public void setPaymentMethod(IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public IPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public void update(String message) {
        System.out.println("Book observable message for: " + message + " for " + this.getName());
    }
}
