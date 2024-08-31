package Questions.LibraryManagementSystem.strategy.notificationMessage;

import Questions.LibraryManagementSystem.enums.NotificationType;
import Questions.LibraryManagementSystem.model.book.Book;

public class BookReturnedMessageImpl implements INotificationMessage{
    @Override
    public boolean isValidMessage(NotificationType notificationType) {
        return notificationType.equals(NotificationType.BOOK_RETURNED);
    }

    @Override
    public String generateMessage(Book book) {
        return book.getTitle() + " returned successfully";
    }
}
