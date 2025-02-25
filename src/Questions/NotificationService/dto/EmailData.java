package Questions.NotificationService.dto;

import Questions.NotificationService.strategy.IAttachment;

import java.util.List;

public class EmailData {
    private final String subject;
    private final String body;
    private final List<IAttachment> attachments;

    public EmailData(String subject, String body, List<IAttachment> attachments) {
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public List<IAttachment> getAttachments() {
        return attachments;
    }
}
