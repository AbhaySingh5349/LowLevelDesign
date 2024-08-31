package Questions.LibraryManagementSystem.strategy.notificationMessage;

import Questions.LibraryManagementSystem.enums.NotificationType;
import Questions.LibraryManagementSystem.model.book.Book;

public class BookNewEditionMessageImpl implements INotificationMessage{
    @Override
    public boolean isValidMessage(NotificationType notificationType) {
        return notificationType.equals(NotificationType.BOOK_NEW_EDITION);
    }

    @Override
    public String generateMessage(Book book) {
        return "New edition for " + book.getTitle() + " is now available";
    }
}
