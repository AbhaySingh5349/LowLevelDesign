package Questions.NotificationService.model;

import Questions.NotificationService.enums.TopicType;
import Questions.NotificationService.strategy.data.INotificationData;

import java.util.Date;

public class Notification {
    String id;
    String msg; // we can remove this, as user should not be allowed to send message at run-time, instead it should be backend templating

//    INotificationData notificationData;

    TopicType type;
    User user;
    Date created_at;

    public Notification(String id, String msg, TopicType type, User user, Date created_at) {
        this.id = id;
        this.msg = msg;
        this.type = type;
        this.user = user;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public TopicType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
