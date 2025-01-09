package Questions.OnlineMeetingScheduler.sol2;

import Questions.OnlineMeetingScheduler.sol2.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;
import Questions.OnlineMeetingScheduler.sol2.repository.ICalendarRepo;
import Questions.OnlineMeetingScheduler.sol2.repository.InMemoryCalendarRepo;
import Questions.OnlineMeetingScheduler.sol2.repository.InMemoryMeetingRepo;
import Questions.OnlineMeetingScheduler.sol2.service.CalendarService;
import Questions.OnlineMeetingScheduler.sol2.service.DateService;
import Questions.OnlineMeetingScheduler.sol2.service.MeetingService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DateService dateService = new DateService();

        InMemoryCalendarRepo calendarRepo = new InMemoryCalendarRepo();
        CalendarService calendarService = new CalendarService(calendarRepo, dateService);
        calendarService.add(new CustomCalendar("h1"));
        calendarService.add(new CustomCalendar("h2"));
        calendarService.add(new CustomCalendar("u1"));
        calendarService.add(new CustomCalendar("u2"));
        calendarService.add(new CustomCalendar("u3"));

        InMemoryMeetingRepo meetingRepo = new InMemoryMeetingRepo();
        MeetingService meetingService = new MeetingService(meetingRepo, calendarService, dateService);

        meetingService.createMeeting("m1", new CustomDate(1, 9), "h1");
        meetingService.inviteUserToMeeting("m1", "h1", "u1");
        meetingService.inviteUserToMeeting("m1", "h1", "u2");
        meetingService.inviteUserToMeeting("m1", "h2", "u3");

        meetingService.createMeeting("m2", new CustomDate(1, 11), "h2");
        meetingService.inviteUserToMeeting("m2", "h2", "u1");
        meetingService.inviteUserToMeeting("m2", "h2", "u3");

        meetingService.displayMeetingMembers("m1");

        System.out.println("**************************************");

        meetingService.acceptMeeting("m1", "u1");
        meetingService.acceptMeeting("m1", "u2");

        meetingService.displayMeetingMembers("m1");

        System.out.println("**************************************");

        meetingService.markUnavailableDateRange("u1", new CustomDate(1, 8), new CustomDate(1, 12));
        meetingService.displayMeetingMembers("m1");

        System.out.println("**************************************");

        meetingService.declineMeeting("m1", "u2");
        meetingService.displayMeetingMembers("m1");

        System.out.println("**************************************");

        meetingService.acceptMeeting("m2", "u1");
        meetingService.acceptMeeting("m2", "u3");
        meetingService.displayMeetingMembers("m2");
    }
}
