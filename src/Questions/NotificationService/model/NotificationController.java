package Questions.NotificationService.model;

import Questions.NotificationService.enums.TopicType;
import Questions.NotificationService.strategy.INotificationSender;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
{
"id": UUID,
"message": "abc sent you a message",
"channels": ['Sms', 'Email']
"type": NEW_MESSAGE,
"user_id": "u_id",
"created_at": Timestamp
}
*/
public class NotificationController {
    List<INotificationSender> notificationSenders;
    Map<String, TopicType> topicTypeMap;

    public void sendNotification(JsonNode jsonNode){
        String id = (String) jsonNode.get("id");
        String msg = (String) jsonNode.get("msg"); // instead we can consider this as some meta-data which can be later used for building smsData or emailData
        List<String> channels = (List<String>) jsonNode.get("channels");
        String topicType = (String) jsonNode.get("type");
        String user_id = (String) jsonNode.get("user_id");
        Date created_at = (Date) jsonNode.get("created_at");

        final Notification notification = new Notification(id, msg, topicTypeMap.get(topicType), new User(user_id) ,created_at);

        for(String channel : channels){
            for(INotificationSender sender : notificationSenders){
                if(sender.doesSupport(channel)){
                    sender.send(notification);
                }
            }
        }
    }
}
