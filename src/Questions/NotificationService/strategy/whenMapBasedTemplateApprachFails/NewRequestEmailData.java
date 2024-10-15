package Questions.NotificationService.strategy.whenMapBasedTemplateApprachFails;

import Questions.NotificationService.model.Notification;
import Questions.NotificationService.strategy.IAttachment;

public class NewRequestEmailData implements IEmailData{
    @Override
    public String getSubject(Notification notification) {
        return "Hi <user>, new request received subject".replace("<user>", notification.getId());
    }

    @Override
    public String getBody(Notification notification) {
        return "";
    }

    @Override
    public IAttachment getAttachment() {
        return null;
    }
}
