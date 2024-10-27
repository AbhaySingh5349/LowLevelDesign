package Questions.RestaurantBookingSystem.model;

public class Booking {
    private final String id;
    private final String userId;
    private final String restaurantId;
    private final Slot slot;
    private final int numOfPeople;

    public Booking(String id, String userId, String restaurantId, Slot slot, int numOfPeople) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.slot = slot;
        this.numOfPeople = numOfPeople;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public Slot getSlot() {
        return slot;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", slot=" + slot +
                ", numOfPeople=" + numOfPeople +
                '}';
    }
}
