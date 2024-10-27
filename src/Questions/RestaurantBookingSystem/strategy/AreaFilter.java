package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class AreaFilter implements IRestaurantFilter{
    private final String area;

    public AreaFilter(String area) {
        this.area = area;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream().filter(restaurant -> restaurant.getArea().contains(area)).collect(Collectors.toList());
    }
}
