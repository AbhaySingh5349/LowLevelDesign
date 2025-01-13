package Questions.ParkingLot.Sol2.model;

import Questions.ParkingLot.Sol2.enums.SpotStatus;
import Questions.ParkingLot.Sol2.enums.SpotType;

public class Spot {
    private final String parkingLotId;
    private final int floorNum;
    private final int spotNum;
    private final String id;
    private SpotType spotType;
    private SpotStatus spotStatus;

    public Spot(String parkingLotId, int floorNum, int spotNum, SpotType spotType) {
        this.parkingLotId = parkingLotId;
        this.floorNum = floorNum;
        this.spotNum = spotNum;
        this.spotType = spotType;
        this.id = parkingLotId + "_" + floorNum + "_" + spotNum;
        this.spotStatus = SpotStatus.AVAILABLE;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public int getSpotNum() {
        return spotNum;
    }

    public String getId() {
        return id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "parkingLotId='" + parkingLotId + '\'' +
                ", floorNum=" + floorNum +
                ", spotNum=" + spotNum +
                ", id='" + id + '\'' +
                ", spotType=" + spotType +
                ", spotStatus=" + spotStatus +
                '}';
    }
}
