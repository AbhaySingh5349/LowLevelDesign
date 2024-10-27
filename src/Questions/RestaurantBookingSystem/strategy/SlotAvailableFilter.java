package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;
import Questions.RestaurantBookingSystem.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SlotAvailableFilter implements IRestaurantFilter{
    private final Slot slot;

    public SlotAvailableFilter(Slot slot) {
        this.slot = slot;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream().filter(restaurant -> restaurant.isSlotAvailable(slot)).collect(Collectors.toList());
    }
}
