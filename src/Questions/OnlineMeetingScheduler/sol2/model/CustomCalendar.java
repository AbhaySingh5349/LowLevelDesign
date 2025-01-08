package Questions.OnlineMeetingScheduler.sol2.model;

import java.util.ArrayList;
import java.util.List;

public class CustomCalendar {
    private final String id;
    private final String userId;
    private final List<String> acceptedMeetings;
    private final List<String> pendingInvites;
    private final List<CustomDate> unavailableDates;

    public CustomCalendar(String id, String userId) {
        this.id = id;
        this.userId = userId;
        this.acceptedMeetings = new ArrayList<>();
        this.pendingInvites = new ArrayList<>();
        this.unavailableDates = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getAcceptedMeetings() {
        return acceptedMeetings;
    }

    public List<String> getPendingInvites() {
        return pendingInvites;
    }

    public List<CustomDate> getUnavailableDates() {
        return unavailableDates;
    }
}
