package Questions.LibraryManagementSystem.service;

import Questions.LibraryManagementSystem.model.book.Book;
import Questions.LibraryManagementSystem.strategy.obervable.BookObservableImpl;
import Questions.LibraryManagementSystem.strategy.obervable.IBookObservable;

import java.util.HashMap;
import java.util.Map;

public class BookObservableRegistry {
    private static volatile BookObservableRegistry instance;
    private final Map<Book, IBookObservable> bookObservableMap;

    private BookObservableRegistry() {
        this.bookObservableMap = new HashMap<>();
    }

    public static synchronized BookObservableRegistry getInstance(){
        if(instance == null){
            synchronized (BookObservableRegistry.class){
                if(instance == null){
                    instance = new BookObservableRegistry();
                }
            }
        }
        return instance;
    }

    public synchronized IBookObservable getBookObservable(Book book){
        return bookObservableMap.computeIfAbsent(book, b -> new BookObservableImpl(b));
    }

    public synchronized void removeObservable(Book book){
        bookObservableMap.remove(book);
    }
}
