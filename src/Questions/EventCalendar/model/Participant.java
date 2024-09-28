package Questions.EventCalendar.model;

import Questions.EventCalendar.enums.ParticipantType;
import Questions.EventCalendar.enums.RSVPStatus;

public class Participant {
    private User user;
    private ParticipantType participantType; // based on this functionalities might change (permissions, display)
    private RSVPStatus rsvpStatus;
}
