package Questions.OnlineMeetingScheduler.sol2.repository;

import Questions.OnlineMeetingScheduler.sol2.model.Meeting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryMeetingRepo implements IMeetingRepo{
    private final Map<String, Meeting> meetingMap;

    public InMemoryMeetingRepo() {
        this.meetingMap = new HashMap<>();
    }

    @Override
    public void add(Meeting meeting) {
        String id = meeting.getId();
        meetingMap.put(id, meeting);
    }

    @Override
    public Meeting getById(String meetingId) {
        return meetingMap.get(meetingId);
    }

    @Override
    public List<Meeting> getMeetingsByUser(String userId) {
        List<Meeting> meetings = new ArrayList<>(meetingMap.values());
        return meetings.stream()
                .filter(meeting -> meeting.getMeetingMembers()
                                          .stream()
                                          .anyMatch(member -> member.getUserId().equals(userId)))
                .collect(Collectors.toList());
    }
}
