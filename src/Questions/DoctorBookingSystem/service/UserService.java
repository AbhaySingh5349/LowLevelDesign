package Questions.DoctorBookingSystem.service;

import Questions.DoctorBookingSystem.enums.BookingStatus;
import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.Booking;
import Questions.DoctorBookingSystem.model.Slot;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.repository.BookingRepository;
import Questions.DoctorBookingSystem.repository.SlotRepository;
import Questions.DoctorBookingSystem.repository.UserRepository;
import Questions.DoctorBookingSystem.strategy.actions.AddSlotsActionDetails;
import Questions.DoctorBookingSystem.strategy.actions.IActionDetails;
import Questions.DoctorBookingSystem.strategy.actions.SearchDoctorActionDetails;
import Questions.DoctorBookingSystem.strategy.filter.IFilter;
import Questions.DoctorBookingSystem.strategy.filter.IFilterDetails;
import Questions.DoctorBookingSystem.strategy.sort.ISort;
import Questions.DoctorBookingSystem.strategy.sort.ISortDetails;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserService {
    private final UserRepository userRepository;
    private final List<IFilter> systemFilters;
    private final List<ISort> systemSortings;
    private final SlotRepository slotRepository;
    private final BookingRepository bookingRepository;

    public UserService(UserRepository userRepository, List<IFilter> systemFilters, List<ISort> systemSortings, SlotRepository slotRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.systemFilters = systemFilters;
        this.systemSortings = systemSortings;
        this.slotRepository = slotRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<User> getDoctors(IActionDetails actionDetails){
        if(!(actionDetails instanceof SearchDoctorActionDetails)){
            System.out.println("Invalid Data provided for SearchDoctorActionDetails");
            return null;
        }

        SearchDoctorActionDetails searchDoctorActionDetails = (SearchDoctorActionDetails) actionDetails;

        UserType userType = searchDoctorActionDetails.getUserType();
        if(!searchDoctorActionDetails.doesSupport(userType)){
            System.out.println("Unauthorized user for searching doctors");
        }

        List<User> doctors = userRepository.getAllDoctors();

        List<IFilterDetails> userFilters = searchDoctorActionDetails.getUserFilterDetails();
        for (IFilter filter : systemFilters){
            for(IFilterDetails filterDetails : userFilters){
                if(filter.doesSupport(filterDetails)){
                    doctors = filter.support(filterDetails, doctors);
                }
            }
        }

        List<ISortDetails> userSortDetails = searchDoctorActionDetails.getUserSortDetails();

        doctors.sort((u1, u2) -> {
            for(ISort sort : systemSortings){
                for(ISortDetails sortDetails : userSortDetails){
                    if(sort.doesSupport(sortDetails)){

                        int result = sort.support(sortDetails, u1, u2);

                        if(result != 0){
                            return result;
                        }
                    }
                }
            }
            return 0;
        });

        String patientId = searchDoctorActionDetails.getUserId();

        System.out.println("************************************************************");
        System.out.println("Doctors matching patient: " + patientId + " search results");
        doctors.forEach(System.out::println);
        System.out.println("************************************************************");

        return doctors;
    }

    public void addDoctorSlots(IActionDetails actionDetails){
        if(!(actionDetails instanceof AddSlotsActionDetails)){
            System.out.println("Invalid Data provided for AddSlotsActionDetails");
            return;
        }

        AddSlotsActionDetails addSlotsActionDetails = (AddSlotsActionDetails) actionDetails;

        UserType userType = addSlotsActionDetails.getUserType();
        if(!addSlotsActionDetails.doesSupport(userType)){
            System.out.println("Unauthorized user for adding slots for doctor");
            return;
        }

        List<Slot> slots = addSlotsActionDetails.getSlots();
        String doctorId = addSlotsActionDetails.getDoctorId();

        slotRepository.add(slots, doctorId);
    }

    public List<Slot> getAvailableSlotsForDoctor(String doctorId){
        return slotRepository.getAvailableSlots(doctorId);
    }

    // we can show extensibility here also like "steps for validations to book a slot" (as later in time more checks may come in)
    public Booking bookSlotForPatient(String doctorId, String patientId){
//        List<Slot> slots = getAvailableSlotsForDoctor(doctorId);

        List<Slot> slots = slotRepository.getAllSlots(doctorId);

        System.out.println("************************************************************");
        System.out.println("slots for doctor: " + doctorId);
        slots.forEach(System.out::println);
        System.out.println("************************************************************");

        Slot preferredSlot = !slots.isEmpty() ? slots.get(0) : null;

        if(preferredSlot != null){
            if(checkPatientAvailabilityForSlot(patientId, preferredSlot)){
                if(preferredSlot.isAvailable()){
                    System.out.println("slot: " + preferredSlot + " is available for booking");
                    preferredSlot.setAvailable(false);
                    bookingRepository.add(new Booking(doctorId, patientId, preferredSlot, BookingStatus.CONFIRMED));
                    System.out.println("booked slot: " + preferredSlot);
                }else{
                    System.out.println("slot: " + preferredSlot + " is already booked, you are added to Q");
                    bookingRepository.add(new Booking(doctorId, patientId, preferredSlot, BookingStatus.WAITING));
                    System.out.println("waiting for slot: " + preferredSlot);
                }
                System.out.println("************************************************************");
            }
        }

        return null;
    }

    private boolean checkPatientAvailabilityForSlot(String patientId, Slot preferredSlot) {
        List<Booking> bookings = bookingRepository.getAllBookings();
        Slot alreadyBookedSlot = bookings.stream()
                .filter(booking -> booking.getPatientId().equals(patientId)
                                && booking.getSlot().equals(preferredSlot)
                                && !booking.getSlot().isAvailable())
                .map(booking -> booking.getSlot())
                .findFirst()
                .orElse(null);

        if(alreadyBookedSlot == null){
            System.out.println("Patient has no overlapping slot, can book it");
        }else {
            System.out.println("Overlapping slot: " + alreadyBookedSlot + " found for patient: " + patientId);
        }

        return alreadyBookedSlot == null;
    }

    public void getTrendingDoctor(){
        Map<String, List<Booking>> bookingMap = bookingRepository.getBookingMap();
        String doctorWithMostBookings = bookingMap.entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(entry -> entry.getKey())
                .orElse(null);

        System.out.println("Trending doctor: " + userRepository.get(doctorWithMostBookings));
    }
}
