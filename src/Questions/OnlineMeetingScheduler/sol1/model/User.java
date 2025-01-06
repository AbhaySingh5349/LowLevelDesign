package Questions.OnlineMeetingScheduler.sol1.model;

public class User {
    private final String id;
    private final String name;
    private final CustomCalendar calendar;

    public User(String id, String name, CustomCalendar calendar) {
        this.id = id;
        this.name = name;
        this.calendar = calendar;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public synchronized void addParticipant(Meeting meeting, User participant) {
        if (meeting.getOrganizer().equals(this)) {
            meeting.addParticipant(participant);
//            System.out.println(this.getName() + " added " + participant.getName() + " to the meeting.");
        } else {
            System.out.println("Only the organizer can add participants.");
        }
    }

    public void removeParticipant(Meeting meeting, User participant) {
        if (meeting.getOrganizer().equals(this)) {
            meeting.removeParticipant(participant);
            System.out.println(this.getName() + " removed " + participant.getName() + " from the meeting.");
        } else {
            System.out.println("Only the organizer can remove participants.");
        }
    }

    public void acceptMeeting(Meeting meeting) throws Exception {
        if (meeting.getParticipants().contains(this)) {
            calendar.acceptMeeting(meeting);
            System.out.println(this.getName() + " accepted the meeting.");
        } else {
            System.out.println(this.getName() + " is not a participant in this meeting.");
        }
    }

    public void declineMeeting(Meeting meeting) {
        if (meeting.getParticipants().contains(this)) {
            System.out.println(this.getName() + " declined the meeting.");
            meeting.removeParticipant(this);
        } else {
            System.out.println(this.getName() + " is not a participant in this meeting.");
        }
    }

    public void markDateRangeUnavailable(CustomDate startDate, CustomDate endDate){
        calendar.markDateRangeUnavailable(startDate, endDate);
    }
}
