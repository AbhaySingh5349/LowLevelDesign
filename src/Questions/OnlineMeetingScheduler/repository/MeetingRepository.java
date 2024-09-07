package Questions.OnlineMeetingScheduler.repository;

import Questions.OnlineMeetingScheduler.model.Meeting;

public interface MeetingRepository {
    void addMeeting(Meeting meeting);
    Meeting getMeetingById(String id);
}
