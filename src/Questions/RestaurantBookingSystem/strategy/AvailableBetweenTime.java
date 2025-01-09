package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableBetweenTime implements IRestaurantFilter{
    private final LocalTime startTime;
    private final LocalTime endTime;

    public AvailableBetweenTime(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(restaurant -> isRestaurantOpenBetweenTime(restaurant))
                .collect(Collectors.toList());
    }

    // check if restaurant is open between two specific times
    private boolean isRestaurantOpenBetweenTime(Restaurant restaurant) {
        LocalTime openingTime = restaurant.getOpeningTime();
        LocalTime closingTime = restaurant.getClosingTime();
        return (startTime.isBefore(closingTime) && endTime.isAfter(openingTime));
    }
}
