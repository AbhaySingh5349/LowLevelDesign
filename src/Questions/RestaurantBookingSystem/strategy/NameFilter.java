package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class NameFilter implements IRestaurantFilter{
    private final String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream().filter(restaurant -> restaurant.getName().contains(name)).collect(Collectors.toList());
    }
}
