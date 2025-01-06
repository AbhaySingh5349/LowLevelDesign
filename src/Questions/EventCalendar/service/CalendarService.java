package Questions.EventCalendar.service;

import Questions.EventCalendar.model.Event;
import Questions.EventCalendar.model.Slot;
import Questions.EventCalendar.model.User;
import Questions.EventCalendar.repository.IEventRepo;

import java.util.List;
import java.util.stream.Collectors;

// calendar in general allows to create events, it depends on guest to accept or not

public class CalendarService {
    private IEventRepo eventRepo;
    private SlotService slotService;

    public void createEvent(Event event){
        // validations (auth for user, availability of slots for guest)
        eventRepo.save(event);
    }

    public Event getEvent(String eventId){
        return eventRepo.get(eventId);
    }

    // here our filtering strategy might change (now we are only considering filtering by overlapping intervals)
    public List<Slot> getFreeSlots(List<User> users, Long start, Long end, Integer increment, Integer duration){
        List<Slot> allSlots = slotService.getAllSlots(start, end, increment, duration);

        for(User user : users){
            List<Slot> bookedSlots = getBookedSlots(user, start, end);

            allSlots = allSlots.stream().filter(slot -> {
                return bookedSlots.stream().noneMatch(bookedSlot -> slot.doesOverlap(bookedSlot));
            }).collect(Collectors.toList());
        }

        return allSlots;
    }

    public List<Slot>
    getBookedSlots(User user, Long start, Long end){
        List<Event> events = eventRepo.getUserEvents(user, start, end);
        return events.stream().map(event -> event.getSlot()).collect(Collectors.toList());
    }
}
