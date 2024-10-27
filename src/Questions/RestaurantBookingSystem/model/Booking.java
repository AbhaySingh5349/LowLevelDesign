package Questions.RestaurantBookingSystem.model;

public class Booking {
    private final String id;
    private final String userId;
    private final Restaurant restaurant;
    private final Slot slot;
    private final int numOfPeople;

    public Booking(String id, String userId, Restaurant restaurant, Slot slot, int numOfPeople) {
        this.id = id;
        this.userId = userId;
        this.restaurant = restaurant;
        this.slot = slot;
        this.numOfPeople = numOfPeople;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Slot getSlot() {
        return slot;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }
}
