package Questions.OnlineMeetingScheduler.sol2.service;

import Questions.OnlineMeetingScheduler.sol2.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;
import Questions.OnlineMeetingScheduler.sol2.model.Meeting;
import Questions.OnlineMeetingScheduler.sol2.repository.ICalendarRepo;

import java.util.List;

public class CalendarService {
    private final ICalendarRepo calendarRepo;
    private final DateService dateService;

    public CalendarService(ICalendarRepo calendarRepo, DateService dateService) {
        this.calendarRepo = calendarRepo;
        this.dateService = dateService;
    }

    public void add(CustomCalendar calendar){
        calendarRepo.add(calendar);
    }

    public CustomCalendar getCalendarForUser(String userId){
        return calendarRepo.getCalendarForUser(userId);
    }

    public void addMeetingToUserCalendar(String meetingId, String userId){
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);

        List<String> acceptedInvites = calendar.getAcceptedMeetings();
        List<String> pendingInvites = calendar.getPendingInvites();
        if(!acceptedInvites.contains(meetingId)){
            acceptedInvites.add(meetingId);
        }

        acceptedInvites.remove(meetingId);
        pendingInvites.remove(meetingId);
    }

    public void acceptMeeting(String meetingId, String userId) {
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);
        List<String> acceptedMeetings = calendar.getAcceptedMeetings();
        List<String> pendingInvites = calendar.getPendingInvites();

        if(!acceptedMeetings.contains(meetingId) && pendingInvites.contains(meetingId)){
            acceptedMeetings.add(meetingId);
            pendingInvites.remove(meetingId);
        }
    }

    public void declineMeeting(String meetingId, String userId) {
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);
        List<String> acceptedMeetings = calendar.getAcceptedMeetings();
        List<String> pendingInvites = calendar.getPendingInvites();

        acceptedMeetings.remove(meetingId);
        pendingInvites.remove(meetingId);
    }

    public void markUnavailableDateRange(String userId, CustomDate startDate, CustomDate endDate) {
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);
        List<CustomDate> unavailableDates = calendar.getUnavailableDates();

        CustomDate currentDate = startDate;
        while(!(currentDate.equals(endDate))){
            if(!unavailableDates.contains(currentDate)){
                unavailableDates.add(currentDate);
            }
            currentDate = dateService.addDays(currentDate, 1);
        }
    }
}
