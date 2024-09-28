package Questions.EventCalendar.repository;

import Questions.EventCalendar.model.Event;
import Questions.EventCalendar.model.User;

import java.util.List;
import java.util.stream.Collectors;

// We avoid keeping POJOs in production as if we not implement toString correctly, it may create issues (eg. User here)
public class InMemoryEventRepo implements IEventRepo{
    List<Event> events;

    @Override
    public void save(Event event) {
        events.add(event);
    }

    @Override
    public Event get(String eventId) {
        return null;
    }

    @Override
    public List<Event> getUserEvents(User user, Long start, Long end) {
        return events.stream().filter(event -> (event.getHost().equals(user) || event.getGuests().contains(user) && event.getSlot().doesOverlap(start, end))).collect(Collectors.toList());
    }
}
