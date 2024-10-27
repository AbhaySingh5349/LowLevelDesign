package Questions.RestaurantBookingSystem.dto;

import Questions.RestaurantBookingSystem.model.Slot;
import Questions.RestaurantBookingSystem.strategy.IRestaurantFilter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SearchRestaurantRequest {
    private final List<IRestaurantFilter> filters;

    public SearchRestaurantRequest(List<IRestaurantFilter> filters) {
        this.filters = filters;
    }

    public List<IRestaurantFilter> getFilters() {
        return filters;
    }
}
