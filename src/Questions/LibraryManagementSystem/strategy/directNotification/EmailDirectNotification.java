package Questions.LibraryManagementSystem.strategy.directNotification;

public class EmailDirectNotification implements IDirectNotification{
    @Override
    public void notifyDirectly(String message) {
        System.out.println("Direct Email Notification: " + message);
    }
}
