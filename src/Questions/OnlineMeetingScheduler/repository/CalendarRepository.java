package Questions.OnlineMeetingScheduler.repository;

import Questions.OnlineMeetingScheduler.model.CustomCalendar;

public interface CalendarRepository {
    void addCalendar(CustomCalendar calendar);
    CustomCalendar getCalendarForUser(String userId) throws Exception;
}
