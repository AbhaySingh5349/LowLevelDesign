package Questions.ParkingLot.Sol2.model;

import java.util.List;

public class ParkingLot {
    private final String id;
    private final int floorCount;
    private final List<Floor> floors;

    public ParkingLot(String id, int floorCount, List<Floor> floors) {
        this.id = id;
        this.floorCount = floorCount;
        this.floors = floors;
    }

    public String getId() {
        return id;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
