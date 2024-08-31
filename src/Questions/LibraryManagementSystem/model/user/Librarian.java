package Questions.LibraryManagementSystem.model.user;

import Questions.LibraryManagementSystem.enums.NotificationType;
import Questions.LibraryManagementSystem.model.book.BookItem;
import Questions.LibraryManagementSystem.service.FineManager;
import Questions.LibraryManagementSystem.strategy.directNotification.IDirectNotification;
import Questions.LibraryManagementSystem.strategy.notificationMessage.INotificationMessage;
import Questions.LibraryManagementSystem.strategy.payment.CashPaymentDetails;
import Questions.LibraryManagementSystem.strategy.payment.IPaymentMethod;
import Questions.LibraryManagementSystem.strategy.price.BasePriceDecorator;
import Questions.LibraryManagementSystem.strategy.price.DiscountPriceDecorator;
import Questions.LibraryManagementSystem.strategy.price.IPriceDecorator;

import java.util.Date;
import java.util.List;

public class Librarian extends User{
    private final FineManager fineManager;
    private final List<IDirectNotification> directNotifications;
    private final List<INotificationMessage> notificationMessages;

    public Librarian(String id, String name, FineManager fineManager, List<IDirectNotification> directNotifications, List<INotificationMessage> notificationMessages) {
        super(id, name);
        this.fineManager = fineManager;
        this.directNotifications = directNotifications;
        this.notificationMessages = notificationMessages;
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

                String message = "";
                for(INotificationMessage notificationMessage : notificationMessages){
                    if(notificationMessage.isValidMessage(NotificationType.BOOK_ISSUED)){
                        message = notificationMessage.generateMessage(bookItem.getBook());
                        break;
                    }
                }

                for(IDirectNotification notification : directNotifications){
                    notification.notifyDirectly(message);
                }
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

            String message = "";
            for(INotificationMessage notificationMessage : notificationMessages){
                if(notificationMessage.isValidMessage(NotificationType.BOOK_RETURNED)){
                    message = notificationMessage.generateMessage(bookItem.getBook());
                    break;
                }
            }

            for(IDirectNotification notification : directNotifications){
                notification.notifyDirectly(message);
            }
        }
    }
}
