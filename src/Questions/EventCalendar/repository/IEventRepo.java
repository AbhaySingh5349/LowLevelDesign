package Questions.EventCalendar.repository;

import Questions.EventCalendar.model.Event;
import Questions.EventCalendar.model.User;

import java.util.List;

public interface IEventRepo {
    void save(Event event);
    Event get(String eventId);
    List<Event> getUserEvents(User user, Long start, Long end);
}
