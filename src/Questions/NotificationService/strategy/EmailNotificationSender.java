package Questions.NotificationService.strategy;

import Questions.NotificationService.dto.EmailData;
import Questions.NotificationService.enums.NotificationType;
import Questions.NotificationService.model.Notification;
import Questions.NotificationService.model.ThirdPartyEmail;
import Questions.NotificationService.strategy.whenStrategiesImplementSameBehaviour.NotificationTemplate;

import java.util.ArrayList;
import java.util.Map;

// 1 more issue with NotificationType data mapping is, if new developer made changes in "EmailNotificationSender" but forgot in others ?
// so we need to enforce our changes -> hence need an Interface or Pojo class which accepts data for all types
// interface {
//   EmailChannelData getEmailData()
//   SmsChannelData getSmsData()
// }

// class ChannelTypeData{
//  EmailChannelData emailData;
//  SmsChannelData smsData;

//  public ChannelTypeData(EmailChannelData emailData, SmsChannelData smsData){
//  }
// }

// now Map<NotificationType, ChannelTypeData> dataMap for each class

public class EmailNotificationSender implements INotificationSender{
    // problem with using map based templating is later other combination of keys can come, so interface might work better in those scenarios
    private final Map<NotificationType, EmailData> emailDataMap;
    private final ThirdPartyEmail thirdPartyEmail;
    private NotificationTemplate notificationTemplate;

    public EmailNotificationSender(Map<NotificationType, EmailData> emailDataMap, ThirdPartyEmail thirdPartyEmail, NotificationTemplate notificationTemplate) {
        this.emailDataMap = emailDataMap;
        this.thirdPartyEmail = thirdPartyEmail;
        this.notificationTemplate = notificationTemplate;
    }

    @Override
    public boolean doesSupport(String channel) {
        return channel.equals("Email");
    }

    @Override
    public void send(Notification notification) {

        String body = notification.getMsg();
        NotificationTemplate.parseString(body, notification);

        EmailData emailData = new EmailData("Subject", body, new ArrayList<>());

        thirdPartyEmail.sendEmail(emailData);
    }
}
