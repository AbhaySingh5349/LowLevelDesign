package Questions.RestaurantBookingSystem;

import Questions.RestaurantBookingSystem.dto.SearchRestaurantRequest;
import Questions.RestaurantBookingSystem.enums.CuisineType;
import Questions.RestaurantBookingSystem.enums.RestaurantType;
import Questions.RestaurantBookingSystem.model.Restaurant;
import Questions.RestaurantBookingSystem.model.Slot;
import Questions.RestaurantBookingSystem.repository.*;
import Questions.RestaurantBookingSystem.service.BookingService;
import Questions.RestaurantBookingSystem.service.RestaurantService;
import Questions.RestaurantBookingSystem.service.SlotService;
import Questions.RestaurantBookingSystem.strategy.DietaryPreferenceFilter;
import Questions.RestaurantBookingSystem.strategy.IRestaurantFilter;
import Questions.RestaurantBookingSystem.strategy.NameFilter;
import Questions.RestaurantBookingSystem.strategy.SlotAvailableFilter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        LocalDate d1 = LocalDate.now();
//        LocalDate d2 = LocalDate.now();
//        System.out.println(d1.equals(d2));
//
//        LocalTime t1 = LocalTime.of(12, 0);
//        LocalTime t2 = LocalTime.of(12, 0);
//        System.out.println(t1.equals(t2));
//
//        Slot s1 = new Slot(d1, t1);
//        Slot s2 = new Slot(d2, t2);
//        System.out.println(s1.equals(s2));

        Restaurant restaurant1 = new Restaurant(
                "1",
                "Pasta Palace",
                "New York",
                "Downtown",
                CuisineType.ITALIAN_CUISINE,
                RestaurantType.NON_VEG,
                LocalTime.of(11, 0), // Opening time
                LocalTime.of(22, 0)  // Closing time
        );

        Restaurant restaurant2 = new Restaurant(
                "2",
                "Sushi World",
                "Los Angeles",
                "Westside",
                CuisineType.CHINESE_CUISINE,
                RestaurantType.NON_VEG,
                LocalTime.of(12, 0),
                LocalTime.of(23, 0)
        );

        Restaurant restaurant3 = new Restaurant(
                "3",
                "Taco Town",
                "Austin",
                "East Austin",
                CuisineType.NORTH_INDIAN_CUISINE,
                RestaurantType.VEG,
                LocalTime.of(10, 0),
                LocalTime.of(20, 0)
        );

        Restaurant restaurant4 = new Restaurant(
                "4",
                "Curry Pasta House",
                "San Francisco",
                "Mission District",
                CuisineType.NORTH_INDIAN_CUISINE,
                RestaurantType.NON_VEG,
                LocalTime.of(11, 30),
                LocalTime.of(22, 30)
        );

        IRestaurantRepo restaurantRepo = new InMemoryRestaurantRepo();
        RestaurantService restaurantService = new RestaurantService(restaurantRepo);
        restaurantRepo.add(restaurant1);
        restaurantRepo.add(restaurant2);
        restaurantRepo.add(restaurant3);
        restaurantRepo.add(restaurant4);

        ISlotRepo slotRepo = new InMemorySlotRepo();
        SlotService slotService = new SlotService(slotRepo);
        slotService.initializeSlots(restaurant1, 7);
        slotService.initializeSlots(restaurant2, 7);
        slotService.initializeSlots(restaurant3, 7);
        slotService.initializeSlots(restaurant4, 7);

        Slot slot = new Slot(LocalDate.now(), LocalTime.of(12, 0));
        System.out.println("booking slot: " + slot);

        List<IRestaurantFilter> filters = List.of(new DietaryPreferenceFilter(RestaurantType.NON_VEG),
                                                  new NameFilter("Pasta"),
                                                  new SlotAvailableFilter(slotService, slot));

        SearchRestaurantRequest searchRestaurantRequest = new SearchRestaurantRequest(filters);
        Restaurant restaurant = restaurantService.getPreferredRestaurant(searchRestaurantRequest);

        System.out.println("Booking at " + restaurant.getName() + " for " + slot);

        IBookingRepo bookingRepo = new InMemoryBookingRepo();
        BookingService bookingService = new BookingService(bookingRepo, slotService);

        System.out.println("previous booked: " + slotService.getBookedSlots(restaurant.getId(), LocalDate.now()));

        bookingService.createBooking(restaurant.getId(), slot);

        System.out.println("post booked: " + slotService.getBookedSlots(restaurant.getId(), LocalDate.now()));
        System.out.println("Available slots: " + slotService.getAvailableSlots(restaurant.getId(),LocalDate.now()));

        System.out.println("Restaurant booking: " + bookingService.getRestaurantBookings(restaurant.getId()));
    }
}
