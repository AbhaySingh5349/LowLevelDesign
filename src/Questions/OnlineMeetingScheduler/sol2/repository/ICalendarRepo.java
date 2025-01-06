package Questions.OnlineMeetingScheduler.sol2.repository;

import Questions.OnlineMeetingScheduler.sol2.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;

import java.util.List;

public interface ICalendarRepo {
    void add(CustomCalendar calendar);
    CustomCalendar getCalendarForUser(String userId);
}
