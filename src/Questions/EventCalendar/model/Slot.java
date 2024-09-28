package Questions.EventCalendar.model;

public class Slot {
    private long startTime;
    private long endTime;

    public boolean doesOverlap(Slot slot){
        return (startTime <= slot.endTime && slot.startTime <= endTime);
    }
    public boolean doesOverlap(Long otherStar, Long otherEnd){
        return (startTime <= otherStar && otherEnd <= endTime);
    }

}
