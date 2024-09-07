package Questions.OnlineMeetingScheduler;

import Questions.OnlineMeetingScheduler.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.model.CustomDate;
import Questions.OnlineMeetingScheduler.model.Meeting;
import Questions.OnlineMeetingScheduler.model.User;
import Questions.OnlineMeetingScheduler.repository.InMemoryCalendarRepositoryImpl;
import Questions.OnlineMeetingScheduler.repository.InMemoryMeetingRepositoryImpl;
import Questions.OnlineMeetingScheduler.repository.InMemoryUserRepositoryImpl;
import Questions.OnlineMeetingScheduler.service.MeetingService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        InMemoryUserRepositoryImpl inMemoryUserRepository = new InMemoryUserRepositoryImpl();
        InMemoryCalendarRepositoryImpl inMemoryCalendar = new InMemoryCalendarRepositoryImpl();
        InMemoryMeetingRepositoryImpl inMemoryMeetingRepository = new InMemoryMeetingRepositoryImpl();

        MeetingService meetingService = new MeetingService(inMemoryUserRepository, inMemoryCalendar, inMemoryMeetingRepository);

        CustomCalendar c1 = new CustomCalendar("1", "1");
        CustomCalendar c2 = new CustomCalendar("2", "2");
        CustomCalendar c3 = new CustomCalendar("3", "3");
        CustomCalendar c4 = new CustomCalendar("4", "4");

        User a = new User("1", "a", c1);
        User b = new User("2", "b", c2);
        User c = new User("3", "c", c3);
        User d = new User("4", "d", c4);

        Meeting m1 = meetingService.createMeeting("1", new CustomDate(1, 2));
        m1.setOrganizer(a);

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for(int i=0;i<1000;i++){
            User user = new User(String.valueOf(i), String.valueOf(i), c1);
            Runnable task = () -> a.addParticipant(m1, user);
            executorService.submit(task);
        }

//        a.addParticipant(m1, b);
//        a.addParticipant(m1, c);
//        a.addParticipant(m1, d);

        System.out.println(m1.getParticipants().size());
        executorService.shutdown();

//        a.removeParticipant(m1, c);

//        c.declineMeeting(m1);

//        c.markDateRangeUnavailable(new CustomDate(1, 1), new CustomDate(1, 4));
//
//        c.acceptMeeting(m1);
//
//        System.out.println("participants invited for meeting: " + m1.getId());
//        List<User> participants = m1.getParticipants();
//        for (User p : participants){
//            System.out.println(p.getName());
//        }
//        System.out.println("**********");
//
//        System.out.println("calender for: " + c.getName());
//        List<Meeting> meetingList = c3.getAcceptedMeetings();
//        meetingList.stream().forEach(meeting -> System.out.println(meeting.getId()));
//        System.out.println("**********");
    }
}
