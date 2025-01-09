package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

// check if restaurant is open after a specific time
public class AvailableAfterTime implements IRestaurantFilter{
    private final LocalTime time;

    public AvailableAfterTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(restaurant -> isRestaurantOpenAfterTime(restaurant))
                .collect(Collectors.toList());
    }

    private boolean isRestaurantOpenAfterTime(Restaurant restaurant) {
        LocalTime openingTime = restaurant.getOpeningTime();
        return !openingTime.isAfter(time);
    }
}
