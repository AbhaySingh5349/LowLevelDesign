package Questions.OnlineMeetingScheduler.sol2.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
    private final String id;
    private final CustomDate date;
    private final String hostId;
    private final List<String> participantIds;

    public Meeting(String id, CustomDate date, String hostId) {
        this.id = id;
        this.date = date;
        this.hostId = hostId;
        this.participantIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public CustomDate getDate() {
        return date;
    }

    public String getHostId() {
        return hostId;
    }

    public List<String> getParticipantIds() {
        return participantIds;
    }
}
