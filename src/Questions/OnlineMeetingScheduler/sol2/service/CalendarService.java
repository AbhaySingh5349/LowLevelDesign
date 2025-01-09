package Questions.OnlineMeetingScheduler.sol2.service;

import Questions.OnlineMeetingScheduler.sol2.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;
import Questions.OnlineMeetingScheduler.sol2.repository.ICalendarRepo;

import java.util.Set;

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

    public void addInviteToUserCalendar(String meetingId, String userId) {
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);
        Set<String> pendingInvites = calendar.getPendingInvites();
        pendingInvites.add(meetingId);
    }

    public boolean addMeeting(String meetingId, String userId, CustomDate date) {
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);
        Set<String> acceptedMeetings = calendar.getAcceptedMeetings();
        Set<String> pendingInvites = calendar.getPendingInvites();
        Set<CustomDate> unavailableDates = calendar.getUnavailableDates();

        if(pendingInvites.contains(meetingId) && !unavailableDates.contains(date)){
            acceptedMeetings.add(meetingId);
            pendingInvites.remove(meetingId);

            return true;
        }else{
            if(unavailableDates.contains(date)){
                System.out.println("userId: " + userId + " trying to accept meeting: " + meetingId + " on unavailable date: " + date);
                return false;
            }
            if(!acceptedMeetings.contains(meetingId)){
                System.out.println("userId: " + userId + " trying to accept incorrect meeting: " + meetingId);
            }

            return false;
        }
    }

    public boolean removeMeeting(String meetingId, String userId) {
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);
        Set<String> acceptedMeetings = calendar.getAcceptedMeetings();
        Set<String> pendingInvites = calendar.getPendingInvites();

        if(acceptedMeetings.contains(meetingId)){
            acceptedMeetings.remove(meetingId);
            pendingInvites.remove(meetingId);

            return true;
        }else{
            System.out.println("userId: " + userId + " trying to remove incorrect meeting: " + meetingId);

            return false;
        }
    }

    public void markUnavailableDateRange(String userId, CustomDate startDate, CustomDate endDate) {
        CustomCalendar calendar = calendarRepo.getCalendarForUser(userId);
        Set<CustomDate> unavailableDates = calendar.getUnavailableDates();

        CustomDate currentDate = startDate;
        while(!(currentDate.equals(endDate))){
            unavailableDates.add(currentDate);
            currentDate = dateService.addDays(currentDate, 1);
        }
    }
}
