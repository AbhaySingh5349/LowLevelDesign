package Questions.LibraryManagementSystem.strategy.notificationMessage;

import Questions.LibraryManagementSystem.enums.NotificationType;
import Questions.LibraryManagementSystem.model.book.Book;

public class BookIssuedMessageImpl implements INotificationMessage{
    @Override
    public boolean isValidMessage(NotificationType notificationType) {
        return notificationType.equals(NotificationType.BOOK_ISSUED);
    }

    @Override
    public String generateMessage(Book book) {
        return book.getTitle() + " issued successfully";
    }
}
