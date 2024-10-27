package Questions.RestaurantBookingSystem.strategy;

import Questions.RestaurantBookingSystem.model.Restaurant;
import Questions.RestaurantBookingSystem.model.Slot;
import Questions.RestaurantBookingSystem.service.SlotService;

import java.util.List;
import java.util.stream.Collectors;

public class SlotAvailableFilter implements IRestaurantFilter{
    private final SlotService slotService;
    private final Slot slot;

    public SlotAvailableFilter(SlotService slotService, Slot slot) {
        this.slotService = slotService;
        this.slot = slot;
    }

    @Override
    public List<Restaurant> getFilteredRestaurants(List<Restaurant> restaurants) {
        return restaurants.stream()
                .filter(restaurant -> slotService.getAvailableSlots(restaurant.getId(), slot.getDate()).contains(slot))
                .collect(Collectors.toList());
    }
}
