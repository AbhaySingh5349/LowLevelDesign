package Questions.OnlineMeetingScheduler.sol2.repository;

import Questions.OnlineMeetingScheduler.sol2.model.CustomCalendar;
import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCalendarRepo implements ICalendarRepo{
    private final Map<String, CustomCalendar> calendarMap;

    public InMemoryCalendarRepo() {
        this.calendarMap = new HashMap<>();
    }

    @Override
    public void add(CustomCalendar calendar) {
        calendarMap.put(calendar.getId(), calendar);
    }

    @Override
    public CustomCalendar getCalendarForUser(String userId) {
        List<CustomCalendar> calendars = new ArrayList<>(calendarMap.values());
        return calendars.stream().filter(calendar -> calendar.getUserId().equals(userId)).findFirst().orElse(null);
    }
}
