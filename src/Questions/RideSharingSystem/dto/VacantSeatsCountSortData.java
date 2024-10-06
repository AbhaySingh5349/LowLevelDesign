package Questions.RideSharingSystem.dto;

public class VacantSeatsCountSortData implements ISortData<Integer>{
    private final int seatCount;

    public VacantSeatsCountSortData(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public Integer getSortData() {
        return seatCount;
    }
}
