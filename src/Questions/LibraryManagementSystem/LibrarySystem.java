package Questions.LibraryManagementSystem;

import Questions.LibraryManagementSystem.model.book.Book;
import Questions.LibraryManagementSystem.model.book.BookItem;
import Questions.LibraryManagementSystem.model.user.Member;
import Questions.LibraryManagementSystem.service.BookObservableRegistry;
import Questions.LibraryManagementSystem.strategy.book.PaperbackBook;
import Questions.LibraryManagementSystem.strategy.membership.NormalMembershipStrategy;
import Questions.LibraryManagementSystem.strategy.membership.PremiumMembershipStrategy;
import Questions.LibraryManagementSystem.strategy.notificationMessage.BookNewEditionMessageImpl;
import Questions.LibraryManagementSystem.strategy.obervable.IBookObservable;

import java.util.Date;

public class LibrarySystem {
    public static void main(String[] args) {
        BookObservableRegistry bookObservableRegistry = BookObservableRegistry.getInstance();

        Book book1 = new Book("1234", "Effective Java", "Joshua Bloch", new Date(), 100);
        Book book2 = new Book("5678", "Design Patterns", "Gang of Four", new Date(), 150);

        IBookObservable notifier1 = bookObservableRegistry.getBookObservable(book1);

        // Create members
        Member alice = new Member("M001", "Alice", new NormalMembershipStrategy());
        Member bob = new Member("M002", "Bob", new PremiumMembershipStrategy());

        // Attach members to the notifiers
        notifier1.addObserver(alice);
        notifier1.addObserver(bob);

        // Notify subscribers about different types of updates
        notifier1.notifySubscribers(new BookNewEditionMessageImpl());

        // Bob unsubscribes from the second book
        notifier1.removeObserver(bob);
        System.out.println("*****************: " + bob.getName() + " unsubscribed " + book1.getTitle());

        // Notify remaining subscribers about another update
        notifier1.notifySubscribers(new BookNewEditionMessageImpl());
    }
}
