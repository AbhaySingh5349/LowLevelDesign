package Questions.RestaurantBookingSystem.model;

import Questions.RestaurantBookingSystem.enums.CuisineType;
import Questions.RestaurantBookingSystem.enums.RestaurantType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private final String id; // Unique ID for the restaurant
    private final String name;
    private final String city;
    private final String area;
    private final CuisineType cuisineType;
    private final RestaurantType restaurantType;
    private final LocalTime openingTime;
    private final LocalTime closingTime;
    private final Map<LocalDate, List<Slot>> availableSlots; // Stores available slots for each date
    private final Map<LocalDate, List<Slot>> bookedSlots;

    public Restaurant(String id, String name, String city, String area, CuisineType cuisineType, RestaurantType restaurantType, LocalTime openingTime, LocalTime closingTime) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.area = area;
        this.cuisineType = cuisineType;
        this.restaurantType = restaurantType;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.availableSlots = Slot.generateSlotsForNextKDays(7, openingTime, closingTime); // Initialize slots for the next 7 days
        this.bookedSlots = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public Map<LocalDate, List<Slot>> getAvailableSlots() {
        return availableSlots;
    }

    // Displays all available slots for the restaurant
    public void displayAvailableSlots() {
        System.out.println("Available slots for restaurant: " + name);
        availableSlots.forEach((date, slots) -> {
            System.out.println("Date: " + date);
            slots.forEach(System.out::println);
        });
    }

    public List<Slot> getAvailableSlotsForDate(LocalDate date) {
        return availableSlots.getOrDefault(date, List.of()); // Returns empty list if no slots available for date
    }

    public List<Slot> getBookedSlotsForDate(LocalDate date){
        return bookedSlots.getOrDefault(date, List.of());
    }

    public boolean bookSlot(Slot slot) {
        LocalDate date = slot.getDate();

        if (isSlotAvailable(slot)) {
            availableSlots.get(date).remove(slot);
            bookedSlots.computeIfAbsent(date, k -> new ArrayList<>()).add(slot);
            return true; // Booking successful
        }else{
            System.out.println("Slot " + slot + " not available");
        }
        return false; // Slot is not available
    }

    public boolean isSlotAvailable(Slot slot){
        LocalDate date = slot.getDate();

        return availableSlots.getOrDefault(date, List.of()).contains(slot);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", cuisineType=" + cuisineType +
                ", restaurantType=" + restaurantType +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
