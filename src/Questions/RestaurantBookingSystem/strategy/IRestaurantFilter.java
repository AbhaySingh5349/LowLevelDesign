package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.util.List;

public interface IRestaurantFilter {
    List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants);
}
