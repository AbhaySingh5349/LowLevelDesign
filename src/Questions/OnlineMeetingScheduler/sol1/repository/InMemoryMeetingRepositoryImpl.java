package Questions.OnlineMeetingScheduler.sol1.repository;

import Questions.OnlineMeetingScheduler.sol1.model.Meeting;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMeetingRepositoryImpl implements MeetingRepository{
    private final Map<String, Meeting> meetingMap;

    public InMemoryMeetingRepositoryImpl() {
        this.meetingMap = new HashMap<>();
    }

    @Override
    public void addMeeting(Meeting meeting) {
        meetingMap.put(meeting.getId(), meeting);
    }

    @Override
    public Meeting getMeetingById(String id) {
        return meetingMap.get(id);
    }
}
