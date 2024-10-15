package Questions.NotificationService.strategy.data;

import Questions.NotificationService.dto.SmsData;

public class SmsNotificationData implements INotificationData{
    private final String body;

    public SmsNotificationData(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
