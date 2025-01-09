package Questions.OnlineMeetingScheduler.sol2.model;

import java.util.HashSet;
import java.util.Set;

public class CustomCalendar {
    private final String userId;
    private final Set<String> acceptedMeetings;
    private final Set<String> pendingInvites;
    private final Set<CustomDate> unavailableDates;

    public CustomCalendar(String userId) {
        this.userId = userId;
        this.acceptedMeetings = new HashSet<>();
        this.pendingInvites = new HashSet<>();
        this.unavailableDates = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public Set<String> getAcceptedMeetings() {
        return acceptedMeetings;
    }

    public Set<String> getPendingInvites() {
        return pendingInvites;
    }

    public Set<CustomDate> getUnavailableDates() {
        return unavailableDates;
    }
}
