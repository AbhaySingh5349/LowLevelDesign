package Questions.RideSharingSystem.model;

// a user can have multiple vehicles, so while creating a ride itself we can decide which vehicle user is using
// no need to add vehicle info here
public class User {
    private final String id;

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
