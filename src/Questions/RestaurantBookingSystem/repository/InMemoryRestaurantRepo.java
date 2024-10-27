package Questions.RestaurantBookingSystem.repository;

import Questions.RestaurantBookingSystem.model.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRestaurantRepo implements IRestaurantRepo{
    Map<String, Restaurant> restaurantMap;

    public InMemoryRestaurantRepo() {
        this.restaurantMap = new HashMap<>();
    }

    @Override
    public void add(Restaurant restaurant) {
        String id = restaurant.getId();
        restaurantMap.put(id, restaurant);
    }

    @Override
    public Restaurant getById(String id) {
        return restaurantMap.get(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurantMap.values());
    }
}
