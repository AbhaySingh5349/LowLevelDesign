package Questions.NotificationService.strategy;

import Questions.NotificationService.dto.SmsData;
import Questions.NotificationService.enums.NotificationType;
import Questions.NotificationService.model.Notification;
import Questions.NotificationService.model.ThirdPartySms;

import java.util.Map;

public class SmsNotificationSender implements INotificationSender{
    // problem with using map based templating is later other combination of keys can come, so interface might work better in those scenarios
    private final Map<NotificationType, SmsData> smsDataMap;
    private final ThirdPartySms thirdPartySms;

    public SmsNotificationSender(Map<NotificationType, SmsData> smsDataMap, ThirdPartySms thirdPartySms) {
        this.smsDataMap = smsDataMap;
        this.thirdPartySms = thirdPartySms;
    }

    @Override
    public boolean doesSupport(String channel) {
        return channel.equals("Sms");
    }

    @Override
    public void send(Notification notification) {
        SmsData smsData = new SmsData(notification.getMsg());
        thirdPartySms.sendSms(smsData);
    }
}
