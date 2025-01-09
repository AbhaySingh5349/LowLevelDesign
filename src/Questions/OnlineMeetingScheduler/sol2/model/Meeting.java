package Questions.OnlineMeetingScheduler.sol2.model;

import java.util.HashSet;
import java.util.Set;

public class Meeting {
    private final String id;
    private final CustomDate date;
    private Set<MeetingMember> meetingMembers;

    public Meeting(String id, CustomDate date, Set<MeetingMember> meetingMembers) {
        this.id = id;
        this.date = date;
        this.meetingMembers = meetingMembers;
    }

    public String getId() {
        return id;
    }

    public CustomDate getDate() {
        return date;
    }

    public Set<MeetingMember> getMeetingMembers() {
        return meetingMembers;
    }

    public void setMeetingMembers(Set<MeetingMember> meetingMembers) {
        this.meetingMembers = meetingMembers;
    }
}
