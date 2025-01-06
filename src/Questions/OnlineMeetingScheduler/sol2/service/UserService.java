package Questions.OnlineMeetingScheduler.sol2.service;

import Questions.OnlineMeetingScheduler.sol2.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;
import Questions.OnlineMeetingScheduler.sol2.model.Meeting;

import java.util.List;

public class UserService {
    private final MeetingService meetingService;
    private final CalendarService calendarService;

    public UserService(MeetingService meetingService, CalendarService calendarService) {
        this.meetingService = meetingService;
        this.calendarService = calendarService;
    }

    public void createMeeting(String meetingId, CustomDate date, String hostId){
        Meeting meeting = new Meeting(meetingId, date, hostId);
        meetingService.add(meeting);
        calendarService.addMeetingToUserCalendar(meetingId, hostId);
    }

    public void inviteUserToMeeting(String meetingId, String hostId, String userId){
        meetingService.inviteUserToMeeting(meetingId, hostId ,userId);
    }

    public void acceptMeeting(String meetingId, String hostId, String userId) {
        meetingService.addUserToMeeting(meetingId, hostId, userId);
    }

    public void declineMeeting(String meetingId, String userId) {

    }

    public void markUnavailableDateRange(String userId, CustomDate startDate, CustomDate endDate) {

    }
}
