package Questions.OnlineMeetingScheduler.sol2.service;

import Questions.OnlineMeetingScheduler.sol2.model.Meeting;
import Questions.OnlineMeetingScheduler.sol2.repository.IMeetingRepo;

import java.util.List;

public class MeetingService {
    private final IMeetingRepo meetingRepo;
    private final CalendarService calendarService;

    public MeetingService(IMeetingRepo meetingRepo, CalendarService calendarService) {
        this.meetingRepo = meetingRepo;
        this.calendarService = calendarService;
    }

    public void add(Meeting meeting){
        meetingRepo.add(meeting);
    }

    public Meeting getById(String meetingId){
        return meetingRepo.getById(meetingId);
    }

    List<Meeting> getMeetingsByUser(String userId){
        return meetingRepo.getMeetingsByUser(userId);
    }

    public void inviteUserToMeeting(String meetingId, String hostId, String userId){
        Meeting meeting = getById(meetingId);

        if(hostId.equals(meeting.getHostId())){
            calendarService.addMeetingToUserCalendar(meetingId, userId);
        }
    }

    public void addUserToMeeting(String meetingId, String hostId, String userId){
        Meeting meeting = getById(meetingId);

        if(hostId.equals(meeting.getHostId())){
            List<String> participantIds = meeting.getParticipantIds();
            if(!participantIds.contains(userId)){
                participantIds.add(userId);

                calendarService.addMeetingToUserCalendar(meetingId, userId);
            }
        }
    }

    public void removeUserFromMeeting(String meetingId, String userId){
        Meeting meeting = getById(meetingId);
        meeting.getParticipantIds().remove(userId);

        
    }
}
