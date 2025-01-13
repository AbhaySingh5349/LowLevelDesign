package Questions.ParkingLot.Sol2.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final String parkingLotId;
    private final int floorNum;
    private final String id;
    private final List<Spot> spots;

    public Floor(String parkingLotId, int floorNum, List<Spot> spots) {
        this.parkingLotId = parkingLotId;
        this.floorNum = floorNum;
        this.id = parkingLotId + "_" + floorNum;
        this.spots = spots;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public String getId() {
        return id;
    }

    public List<Spot> getSpots() {
        return spots;
    }
}
