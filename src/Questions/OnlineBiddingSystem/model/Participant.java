package Questions.OnlineBiddingSystem.model;

import Questions.OnlineBiddingSystem.enums.ParticipantType;

import java.util.Objects;

public class Participant {
    private final User user;
    private final ParticipantType type;

    public Participant(User user, ParticipantType type) {
        this.user = user;
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public ParticipantType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(user, that.user) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, type);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "user=" + user +
                ", type=" + type +
                '}';
    }
}
