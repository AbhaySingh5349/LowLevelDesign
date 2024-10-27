package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.enums.CuisineType;
import Questions.RestaurantBookingSystem.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class CuisineFilter implements IRestaurantFilter{
    private final CuisineType cuisineType;

    public CuisineFilter(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream().filter(restaurant -> restaurant.getCuisineType().equals(cuisineType)).collect(Collectors.toList());
    }
}
