package Questions.NotificationService.strategy.whenStrategiesImplementSameBehaviour;

import Questions.NotificationService.model.Notification;

public class NotificationTemplate{
    public static String parseString(String msg, Notification notification){
        return msg.replace("<user>", notification.getUser().getId());
    }
}
