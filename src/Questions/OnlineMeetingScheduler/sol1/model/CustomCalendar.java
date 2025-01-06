package Questions.OnlineMeetingScheduler.sol1.model;

import Questions.OnlineMeetingScheduler.sol1.exceptions.CalendarException;

import java.util.ArrayList;
import java.util.List;

public class CustomCalendar {
    private final String id;
    private final String userId;
    private final List<Meeting> acceptedMeetings;
    private final List<CustomDate> unavailableDates;

    public CustomCalendar(String id, String userId){
        this.id = id;
        this.userId = userId;
        this.acceptedMeetings = new ArrayList<>();
        this.unavailableDates = new ArrayList<>();
    }

    public void acceptMeeting(Meeting meeting){
        CustomDate date = meeting.getDate();

        if(isUnavailableDate(date)){
            throw new CalendarException("occupied with other meeting or unavailable");
        }

        acceptedMeetings.add(meeting);
    }

    public void declineMeeting(Meeting meeting) throws Exception {
        CustomDate date = meeting.getDate();

        if(isUnavailableDate(date)){
            throw new Exception("occupied with other meeting");
        }

        acceptedMeetings.remove(meeting);
    }

    public void markDateRangeUnavailable(CustomDate startDate, CustomDate endDate){
        // Calculate the delta (difference in days)
        int delta = startDate.getDelta(endDate);

        // Add dates from startDate to endDate (including both)
        for (int i = 0; i <= delta; i++) {
            CustomDate newDate = startDate.addDays(i);
            unavailableDates.add(newDate);
        }
    }

    private boolean isUnavailableDate(CustomDate d){
        return unavailableDates.stream()
                .map(date -> CustomDate.serializeDate(date))   // Map each date to its serialized string
                .anyMatch(serializedDate -> serializedDate.equals(CustomDate.serializeDate(d)));
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public List<Meeting> getAcceptedMeetings() {
        return acceptedMeetings;
    }

    public List<CustomDate> getUnavailableDates() {
        return unavailableDates;
    }
}
