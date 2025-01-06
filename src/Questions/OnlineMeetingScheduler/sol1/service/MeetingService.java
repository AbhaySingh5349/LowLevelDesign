package Questions.OnlineMeetingScheduler.sol1.service;

import Questions.OnlineMeetingScheduler.sol1.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.sol1.model.CustomDate;
import Questions.OnlineMeetingScheduler.sol1.model.Meeting;
import Questions.OnlineMeetingScheduler.sol1.model.User;
import Questions.OnlineMeetingScheduler.sol1.repository.CalendarRepository;
import Questions.OnlineMeetingScheduler.sol1.repository.MeetingRepository;
import Questions.OnlineMeetingScheduler.sol1.repository.UserRepository;

public class MeetingService {
    UserRepository userRepository;
    CalendarRepository calendarRepository;
    MeetingRepository meetingRepository;

    public MeetingService(UserRepository userRepository, CalendarRepository calendarRepository, MeetingRepository meetingRepository) {
        this.userRepository = userRepository;
        this.calendarRepository = calendarRepository;
        this.meetingRepository = meetingRepository;
    }

    public Meeting createMeeting(String id, CustomDate date){
        Meeting meeting = new Meeting(id, date);
        meetingRepository.addMeeting(meeting);

        return meeting;
    }

    public CustomCalendar createCalendar(String id, String userId){
        CustomCalendar calendar = new CustomCalendar(id, userId);
        calendarRepository.addCalendar(calendar);

        return calendar;
    }

    public User createUser(String id, String name, CustomCalendar calendar){
        User user = new User(id, name, calendar);
        userRepository.addUser(user);

        return user;
    }
}
