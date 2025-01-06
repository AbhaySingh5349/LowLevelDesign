package Questions.OnlineMeetingScheduler.sol2.repository;

import Questions.OnlineMeetingScheduler.sol2.model.Meeting;

import java.util.List;

public interface IMeetingRepo {
    void add(Meeting meeting);
    Meeting getById(String meetingId);
    List<Meeting> getMeetingsByUser(String userId);
}
