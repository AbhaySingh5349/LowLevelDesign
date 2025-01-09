package Questions.OnlineMeetingScheduler.sol2.service;

import Questions.OnlineMeetingScheduler.sol2.enums.MeetingRole;
import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;
import Questions.OnlineMeetingScheduler.sol2.model.Meeting;
import Questions.OnlineMeetingScheduler.sol2.model.MeetingMember;
import Questions.OnlineMeetingScheduler.sol2.repository.IMeetingRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MeetingService {
    private final IMeetingRepo meetingRepo;
    private final CalendarService calendarService;
    private final DateService dateService;

    public MeetingService(IMeetingRepo meetingRepo, CalendarService calendarService, DateService dateService) {
        this.meetingRepo = meetingRepo;
        this.calendarService = calendarService;
        this.dateService = dateService;
    }

    public void add(Meeting meeting){
        meetingRepo.add(meeting);
    }

    public Meeting getById(String meetingId){
        return meetingRepo.getById(meetingId);
    }

    public List<Meeting> getMeetingsByUser(String userId){
        return meetingRepo.getMeetingsByUser(userId);
    }

    public void createMeeting(String meetingId, CustomDate date, String hostId){
        Set<MeetingMember> participants = new HashSet<>();
        participants.add(new MeetingMember(hostId, meetingId, MeetingRole.HOST));

        Meeting meeting = new Meeting(meetingId, date, participants);
        add(meeting);

        calendarService.addInviteToUserCalendar(meetingId, hostId);
        calendarService.addMeeting(meetingId, hostId, date);
    }

    public void inviteUserToMeeting(String meetingId, String hostId, String userId){
        Meeting meeting = getById(meetingId);

        if(validateHost(hostId, meeting)){
            calendarService.addInviteToUserCalendar(meetingId, userId);
        }else {
            System.out.println("host: " + hostId + " does not have permission to add: " + userId + " to meeting: " + meetingId);
        }
    }

    public void removeUserFromMeeting(String meetingId, String hostId, String userId){
        Meeting meeting = getById(meetingId);

        if(validateHost(hostId, meeting)){
            calendarService.removeMeeting(meetingId, userId);

            Set<MeetingMember> meetingMembers = meeting.getMeetingMembers();
            meetingMembers = meetingMembers.stream().filter(meetingMember -> !meetingMember.getUserId().equals(userId)).collect(Collectors.toSet());
            meeting.setMeetingMembers(meetingMembers);
        }else {
            System.out.println("host: " + hostId + " does not have permission to remove: " + userId + " from meeting: " + meetingId);
        }
    }

    public void acceptMeeting(String meetingId, String userId){
        Meeting meeting = meetingRepo.getById(meetingId);
        if(calendarService.addMeeting(meetingId, userId, meeting.getDate())){
            Set<MeetingMember> meetingMembers = meeting.getMeetingMembers();
            meetingMembers.add(new MeetingMember(userId, meetingId, MeetingRole.PARTICIPANT));
        }
    }

    public void declineMeeting(String meetingId, String userId){
        if(calendarService.removeMeeting(meetingId, userId)){
            Meeting meeting = meetingRepo.getById(meetingId);
            Set<MeetingMember> meetingMembers = meeting.getMeetingMembers();
            meetingMembers = meetingMembers.stream().filter(meetingMember -> !meetingMember.getUserId().equals(userId)).collect(Collectors.toSet());
            meeting.setMeetingMembers(meetingMembers);
        }
    }

    public void markUnavailableDateRange(String userId, CustomDate startDate, CustomDate endDate){
        calendarService.markUnavailableDateRange(userId, startDate, endDate);
        List<Meeting> meetings = meetingRepo.getMeetingsByUser(userId);

        for(Meeting meeting : meetings){
            CustomDate date = meeting.getDate();

            if(dateService.isDateWithinRange(startDate, endDate, date)){
                MeetingMember hostMember = meeting.getMeetingMembers().stream()
                                                                      .filter(member -> member.getRole().equals(MeetingRole.HOST))
                                                                      .findFirst().orElse(null);
                if(hostMember != null){
                    String hostId = hostMember.getUserId();
                    removeUserFromMeeting(meeting.getId(), hostId, userId);
                }
            }
        }
    }

    public void displayMeetingMembers(String meetingId){
        Meeting meeting = meetingRepo.getById(meetingId);
        Set<MeetingMember> meetingMembers = meeting.getMeetingMembers();
        meetingMembers.forEach(System.out::println);
    }

    private boolean validateHost(String hostId, Meeting meeting) {
        Set<MeetingMember> meetingMembers = meeting.getMeetingMembers();
        return meetingMembers.stream()
                .anyMatch(member -> member.getUserId().equals(hostId) && member.getRole().equals(MeetingRole.HOST));
    }
}
