package Questions.LibraryManagementSystem.strategy.notificationMessage;

import Questions.LibraryManagementSystem.enums.NotificationType;
import Questions.LibraryManagementSystem.model.book.Book;

public interface INotificationMessage {
    boolean isValidMessage(NotificationType notificationType);
    String generateMessage(Book book);
}
