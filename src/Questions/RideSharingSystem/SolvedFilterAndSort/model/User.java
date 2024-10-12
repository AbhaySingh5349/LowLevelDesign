package Questions.RideSharingSystem.SolvedFilterAndSort.model;

public class User {
    private String id;
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
