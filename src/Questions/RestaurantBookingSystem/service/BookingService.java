package Questions.RestaurantBookingSystem.service;

import Questions.RestaurantBookingSystem.model.Booking;
import Questions.RestaurantBookingSystem.model.Slot;
import Questions.RestaurantBookingSystem.repository.IBookingRepo;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.UUID;

public class BookingService {
    private final IBookingRepo bookingRepo;
    private final SlotService slotService;

    public BookingService(IBookingRepo bookingRepo, SlotService slotService) {
        this.bookingRepo = bookingRepo;
        this.slotService = slotService;
    }

    public void createBooking(String restaurantId, Slot slot){
//        synchronized (slot){
//            boolean isSlotAvailable = slotService.isSlotAvailable(restaurantId, slot);
//            if(isSlotAvailable){
//                slotService.bookSlot(restaurantId, slot);
//                Booking booking = new Booking(UUID.randomUUID().toString(), "user", restaurantId, slot, 2);
//                bookingRepo.add(booking, restaurantId);
//            }
//        }

        boolean isSlotAvailable = slotService.isSlotAvailable(restaurantId, slot);
        if(isSlotAvailable){
            slotService.bookSlot(restaurantId, slot);
            Booking booking = new Booking(UUID.randomUUID().toString(), "user", restaurantId, slot, 2);
            bookingRepo.add(booking, restaurantId);
        }
    }

    public Booking getBookingById(String id){
        return bookingRepo.getBookingById(id);
    }

    List<Booking> getAllBookings(){
        return bookingRepo.getAllBookings();
    }

    public List<Booking> getRestaurantBookings(String restaurantId){
        return bookingRepo.getRestaurantBookings(restaurantId);
    }
}
