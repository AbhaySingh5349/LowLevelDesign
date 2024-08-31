package Questions.LibraryManagementSystem.strategy.directNotification;

public class SmsDirectNotification implements IDirectNotification{
    @Override
    public void notifyDirectly(String message) {
        System.out.println("Direct Sms Notification: " + message);
    }
}
