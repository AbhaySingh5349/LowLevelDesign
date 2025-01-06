package Questions.OnlineMeetingScheduler.sol1.repository;

import Questions.OnlineMeetingScheduler.sol1.model.CustomCalendar;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCalendarRepositoryImpl implements CalendarRepository{
    private final Map<String, CustomCalendar> calendarMap;

    public InMemoryCalendarRepositoryImpl() {
        this.calendarMap = new HashMap<>();
    }

    @Override
    public void addCalendar(CustomCalendar calendar) {
        calendarMap.put(calendar.getId(), calendar);
    }

    @Override
    public CustomCalendar getCalendarForUser(String userId) throws Exception {
        for(CustomCalendar calendar : calendarMap.values()){
            if(calendar.getUserId().equals(userId)){
                return calendar;
            }
        }
        throw new Exception("no calendar for user id: " + userId);
    }
}
