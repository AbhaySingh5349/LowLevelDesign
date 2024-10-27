package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.enums.RestaurantType;
import Questions.RestaurantBookingSystem.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class DietaryPreferenceFilter implements IRestaurantFilter{
    private final RestaurantType restaurantType;

    public DietaryPreferenceFilter(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream().filter(restaurant -> restaurant.getRestaurantType().equals(restaurantType)).collect(Collectors.toList());
    }
}
