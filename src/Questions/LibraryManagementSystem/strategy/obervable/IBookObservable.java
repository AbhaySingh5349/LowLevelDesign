package Questions.LibraryManagementSystem.strategy.obervable;

import Questions.LibraryManagementSystem.strategy.notificationMessage.INotificationMessage;
import Questions.LibraryManagementSystem.strategy.observer.IBookObserver;

public interface IBookObservable {
    void addObserver(IBookObserver observer);
    void removeObserver(IBookObserver observer);
    void notifySubscribers(INotificationMessage notificationMessage);
}
