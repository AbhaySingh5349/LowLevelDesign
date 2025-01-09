package Questions.OnlineMeetingScheduler.sol2.repository;

import Questions.OnlineMeetingScheduler.sol2.model.CustomCalendar;

public interface ICalendarRepo {
    void add(CustomCalendar calendar);
    CustomCalendar getCalendarForUser(String userId);
}
