package Questions.OnlineMeetingScheduler.sol1.repository;

import Questions.OnlineMeetingScheduler.sol1.model.Meeting;

public interface MeetingRepository {
    void addMeeting(Meeting meeting);
    Meeting getMeetingById(String id);
}
