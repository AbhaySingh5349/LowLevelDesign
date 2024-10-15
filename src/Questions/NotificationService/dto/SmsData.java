package Questions.NotificationService.dto;

public class SmsData {
    private final String body;

    public SmsData(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
