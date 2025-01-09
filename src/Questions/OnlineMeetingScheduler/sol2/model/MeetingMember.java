package Questions.OnlineMeetingScheduler.sol2.model;

import Questions.OnlineMeetingScheduler.sol2.enums.MeetingRole;

public class MeetingMember {
    private String userId;
    private String meetingId;
    private MeetingRole role;

    public MeetingMember(String userId, String meetingId, MeetingRole role) {
        this.userId = userId;
        this.meetingId = meetingId;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public MeetingRole getRole() {
        return role;
    }

    public void setRole(MeetingRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MeetingMember{" +
                "userId='" + userId + '\'' +
                ", meetingId='" + meetingId + '\'' +
                ", role=" + role +
                '}';
    }
}
