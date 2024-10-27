package Questions.RestaurantBookingSystem.model;

import Questions.RestaurantBookingSystem.enums.CuisineType;
import Questions.RestaurantBookingSystem.enums.RestaurantType;

import java.time.LocalTime;

public class Restaurant {
    private final String id; // Unique ID for the restaurant
    private final String name;
    private final String city;
    private final String area;
    private final CuisineType cuisineType;
    private final RestaurantType restaurantType;
    private final LocalTime openingTime;
    private final LocalTime closingTime;

    public Restaurant(String id, String name, String city, String area, CuisineType cuisineType, RestaurantType restaurantType, LocalTime openingTime, LocalTime closingTime) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.area = area;
        this.cuisineType = cuisineType;
        this.restaurantType = restaurantType;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
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
