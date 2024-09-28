package Questions.EventCalendar.model;

import java.util.List;

// problem with current design, our event is restricted to Host & Guest , but we can have more type of users (eg. multiple admins, editors)
// so we can have separate class Participant: private List<Participant> guests;
public class Event {
    private String id;
    private Slot slot;

    private User host;
    private List<User> guests;

    private Location location;

    public String getId() {
        return id;
    }

    public Slot getSlot() {
        return slot;
    }

    public User getHost() {
        return host;
    }

    public List<User> getGuests() {
        return guests;
    }

    public Location getLocation() {
        return location;
    }
}
