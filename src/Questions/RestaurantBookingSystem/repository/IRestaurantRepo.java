package Questions.RestaurantBookingSystem.repository;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.util.List;

public interface IRestaurantRepo {
    void add(Restaurant restaurant);
    Restaurant getById(String id);
    List<Restaurant> getAllRestaurants();
}
