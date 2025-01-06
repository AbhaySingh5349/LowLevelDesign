package Questions.OnlineMeetingScheduler.sol1.repository;

import Questions.OnlineMeetingScheduler.sol1.model.CustomCalendar;

public interface CalendarRepository {
    void addCalendar(CustomCalendar calendar);
    CustomCalendar getCalendarForUser(String userId) throws Exception;
}
