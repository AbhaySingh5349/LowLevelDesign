package Questions.RestaurantBookingSystem.service;

import Questions.RestaurantBookingSystem.dto.SearchRestaurantRequest;
import Questions.RestaurantBookingSystem.model.Restaurant;
import Questions.RestaurantBookingSystem.repository.IRestaurantRepo;
import Questions.RestaurantBookingSystem.strategy.IRestaurantFilter;

import java.util.List;
import java.util.Random;

public class RestaurantService {
    IRestaurantRepo restaurantRepo;

    public RestaurantService(IRestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public Restaurant getPreferredRestaurant(SearchRestaurantRequest request){
        List<Restaurant> restaurants = restaurantRepo.getAllRestaurants();

        // filtering
        List<IRestaurantFilter> filters = request.getFilters();

        List<Restaurant> filteredRestaurants = filters.stream()
                .reduce(restaurants, (intermediateFilteredRestaurants, filter) -> filter.getFilteredRestaurants(intermediateFilteredRestaurants), (a,b) -> b);

//        System.out.println("Filtered Restaurants");
//        filteredRestaurants.forEach(System.out::println);

//        Restaurant restaurant = !filteredRestaurants.isEmpty() ? filteredRestaurants.get(0) : null;

        int random = new Random().nextInt(filteredRestaurants.size());
        Restaurant restaurant = !filteredRestaurants.isEmpty()
                ? filteredRestaurants.get(random)
                : null;

        if(restaurant == null){
//            throw new IllegalArgumentException("No matching Restaurant available");
        }

        return restaurant;
    }
}
