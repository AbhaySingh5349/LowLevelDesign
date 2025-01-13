package Questions.ParkingLot.Sol1.model;

public class ParkingTicket {
    private final String ticketId;
    private final ParkingSpot parkingSpot;
    private final long issuedAt;

    public ParkingTicket(String ticketId, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.issuedAt = System.currentTimeMillis();
    }

    public ParkingSpot getSpot() {
        return parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getIssuedAt(){
        return issuedAt;
    }

    public String getSpotId(){
        return parkingSpot.getSpotId();
    }
}
