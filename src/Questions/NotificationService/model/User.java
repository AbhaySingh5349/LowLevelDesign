package Questions.NotificationService.model;

public class User {
    private final String id;
    private String phoneNum;
    private String email;

    public User(String id, String phoneNum, String email) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }
}
