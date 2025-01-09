package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableBeforeTime implements IRestaurantFilter{
    private final LocalTime time;

    public AvailableBeforeTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(restaurant -> isRestaurantOpenBeforeTime(restaurant))
                .collect(Collectors.toList());
    }

    // check if restaurant is open before a specific time
    private boolean isRestaurantOpenBeforeTime(Restaurant restaurant) {
        LocalTime closingTime = restaurant.getClosingTime();
        return !closingTime.isBefore(time);
    }
}
