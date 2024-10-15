package Questions.NotificationService.strategy;

import Questions.NotificationService.model.Notification;

public interface INotificationSender {
    boolean doesSupport(String channel);
    void send(Notification notification);
}
