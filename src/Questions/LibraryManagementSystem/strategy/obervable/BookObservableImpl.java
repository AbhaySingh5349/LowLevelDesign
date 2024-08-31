package Questions.LibraryManagementSystem.strategy.obervable;

import Questions.LibraryManagementSystem.model.book.Book;
import Questions.LibraryManagementSystem.strategy.notificationMessage.INotificationMessage;
import Questions.LibraryManagementSystem.strategy.observer.IBookObserver;

import java.util.ArrayList;
import java.util.List;

public class BookObservableImpl implements IBookObservable{
    private final Book book;
    private List<IBookObserver> observersList;

    public BookObservableImpl(Book book) {
        this.book = book;
        this.observersList = new ArrayList<>();
    }

    @Override
    public void addObserver(IBookObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(IBookObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifySubscribers(INotificationMessage notificationMessage) {
        for (IBookObserver observer : observersList){
            observer.update(notificationMessage.generateMessage(book));
        }
    }
}
