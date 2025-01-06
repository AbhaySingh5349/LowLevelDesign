package Questions.OnlineMeetingScheduler.sol1.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
    private final String id;
    private final CustomDate date;
    private User organizer;
    private List<User> participants;

    public Meeting(String id, CustomDate date) {
        this.id = id;
        this.date = date;
        this.participants = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public CustomDate getDate() {
        return date;
    }

    public User getOrganizer() {
        return organizer;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public synchronized void addParticipant(User participant) {
        if(this.organizer != null){
            this.participants.add(participant);
        }
    }

    public void removeParticipant(User participant){
        this.participants.remove(participant);
    }
}
