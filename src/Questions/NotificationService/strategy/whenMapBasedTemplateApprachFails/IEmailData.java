package Questions.NotificationService.strategy.whenMapBasedTemplateApprachFails;

import Questions.NotificationService.model.Notification;
import Questions.NotificationService.strategy.IAttachment;

// in scenarios where map based message templating might fail
// but interfaces works well when we have different behaviours
// in this case all types of Topic will more or less implement same behaviour i.e way to generate subject, body
public interface IEmailData {
    String getSubject(Notification notification);
    String getBody(Notification notification);
    IAttachment getAttachment();
}
