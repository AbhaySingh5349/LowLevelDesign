package Questions.DoctorBookingSystem;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.Booking;
import Questions.DoctorBookingSystem.model.Slot;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.repository.BookingRepository;
import Questions.DoctorBookingSystem.repository.SlotRepository;
import Questions.DoctorBookingSystem.repository.UserRepository;
import Questions.DoctorBookingSystem.service.UserService;
import Questions.DoctorBookingSystem.strategy.actions.AddSlotsActionDetails;
import Questions.DoctorBookingSystem.strategy.actions.SearchDoctorActionDetails;
import Questions.DoctorBookingSystem.strategy.filter.*;
import Questions.DoctorBookingSystem.strategy.sort.*;
import Questions.DoctorBookingSystem.strategy.user.DoctorUserProfileDetails;
import Questions.DoctorBookingSystem.strategy.user.PatientUserProfileDetails;
import Questions.DoctorBookingSystem.utils.SearchQueryBuilder;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        User p1 = new User("p1", UserType.PATIENT, new PatientUserProfileDetails("first patient"));
        User p2 = new User("p2", UserType.PATIENT, new PatientUserProfileDetails("second patient"));

        User d1 = new User("d1", UserType.DOCTOR, new DoctorUserProfileDetails(DoctorType.GENERAL_PHYSICIAN, 0));
        User d2 = new User("d2", UserType.DOCTOR, new DoctorUserProfileDetails(DoctorType.GENERAL_PHYSICIAN, 5));
        User d3 = new User("d3", UserType.DOCTOR, new DoctorUserProfileDetails(DoctorType.GENERAL_PHYSICIAN, 3));
        User d4 = new User("d4", UserType.DOCTOR, new DoctorUserProfileDetails(DoctorType.CARDIOLOGIST, 8));
        User d5 = new User("d5", UserType.DOCTOR, new DoctorUserProfileDetails(DoctorType.CARDIOLOGIST, 3));
        User d6 = new User("d6", UserType.DOCTOR, new DoctorUserProfileDetails(DoctorType.DERMATOLOGIST, 6));

        UserRepository userRepository = new UserRepository();
        userRepository.add(p1);
        userRepository.add(p2);
        userRepository.add(d1);
        userRepository.add(d2);
        userRepository.add(d3);
        userRepository.add(d4);
        userRepository.add(d5);
        userRepository.add(d6);

        SlotRepository slotRepository = new SlotRepository();
        BookingRepository bookingRepository = new BookingRepository();

        List<IFilter> systemFilters = List.of(new UserTypeFilter(), new DoctorTypeFilter(), new RatingFilter());
        List<ISort> systemSortings = List.of(new RatingSort(), new DoctorSort(), new EarliestSlotAvailabilitySort());

        UserService userService = new UserService(userRepository, systemFilters, systemSortings, slotRepository, bookingRepository);

        Slot d1_s1 = new Slot(LocalTime.of(8,30), LocalTime.of(9, 0));
        Slot d1_s2 = new Slot(LocalTime.of(11,30), LocalTime.of(12, 0));
        Slot d1_s3 = new Slot(LocalTime.of(17,30), LocalTime.of(18, 0));
        Slot d1_s4 = new Slot(LocalTime.of(18,30), LocalTime.of(19, 0));
        List<Slot> d1_slots = Arrays.asList(d1_s1, d1_s2, d1_s3, d1_s4);
        userService.addDoctorSlots(new AddSlotsActionDetails(d1_slots, UserType.DOCTOR, "d1"));

        Slot d2_s1 = new Slot(LocalTime.of(9,30), LocalTime.of(10, 0));
        Slot d2_s2 = new Slot(LocalTime.of(10,30), LocalTime.of(11, 0));
        Slot d2_s3 = new Slot(LocalTime.of(11,30), LocalTime.of(12, 0));
        List<Slot> d2_slots = Arrays.asList(d2_s1, d2_s2, d2_s3);
        userService.addDoctorSlots(new AddSlotsActionDetails(d2_slots, UserType.DOCTOR, "d2"));

        Slot d3_s1 = new Slot(LocalTime.of(17,30), LocalTime.of(18, 0));
        Slot d3_s2 = new Slot(LocalTime.of(18,30), LocalTime.of(19, 0));
        List<Slot> d3_slots = Arrays.asList(d3_s1, d3_s2);
        userService.addDoctorSlots(new AddSlotsActionDetails(d3_slots, UserType.DOCTOR, "d3"));

        Slot d4_s1 = new Slot(LocalTime.of(8,30), LocalTime.of(9, 0));
        Slot d4_s2 = new Slot(LocalTime.of(14,0), LocalTime.of(14, 30));
        List<Slot> d4_slots = Arrays.asList(d4_s1, d4_s2);
        userService.addDoctorSlots(new AddSlotsActionDetails(d4_slots, UserType.DOCTOR, "d4"));

        Slot d5_s1 = new Slot(LocalTime.of(9,30), LocalTime.of(10, 0));
        Slot d5_s2 = new Slot(LocalTime.of(17,0), LocalTime.of(17, 30));
        List<Slot> d5_slots = Arrays.asList(d5_s1, d5_s2);
        userService.addDoctorSlots(new AddSlotsActionDetails(d5_slots, UserType.DOCTOR, "d5"));

        Slot d6_s1 = new Slot(LocalTime.of(13,30), LocalTime.of(14, 0));
        Slot d6_s2 = new Slot(LocalTime.of(15,0), LocalTime.of(15, 30));
        List<Slot> d6_slots = Arrays.asList(d6_s1, d6_s2);
        userService.addDoctorSlots(new AddSlotsActionDetails(d6_slots, UserType.DOCTOR, "d6"));

        UserTypeFilterDetails userTypeFilterDetails = new UserTypeFilterDetails(UserType.DOCTOR);
        DoctorTypeFilterDetails doctorTypeFilterDetails = new DoctorTypeFilterDetails(DoctorType.CARDIOLOGIST);
        RatingFilterDetails ratingFilterDetails = new RatingFilterDetails(1);

        List<IFilterDetails> userFilterDetails = List.of(userTypeFilterDetails, doctorTypeFilterDetails, ratingFilterDetails);

        RatingSortDetails ratingSortDetails = new RatingSortDetails();
//        DoctorTypeSortDetails doctorTypeSortDetails = new DoctorTypeSortDetails(DoctorType.GENERAL_PHYSICIAN);
        EarliestSlotAvailabilitySortDetails earliestSlotAvailabilitySortDetails = new EarliestSlotAvailabilitySortDetails(slotRepository);

//        ratingSortDetails, doctorTypeSortDetails
        List<ISortDetails> userSortDetails = List.of(earliestSlotAvailabilitySortDetails);

        SearchDoctorActionDetails q1_searchDoctorActionDetails = new SearchDoctorActionDetails(userFilterDetails, userSortDetails, UserType.PATIENT, "p1");

        List<User> q1_doctors = userService.getDoctors(q1_searchDoctorActionDetails);

        User q1_preferredDoctor = !q1_doctors.isEmpty() ? q1_doctors.get(0) : null;
        if(q1_preferredDoctor != null){
            userService.bookSlotForPatient(q1_preferredDoctor.getId(), "p1");
        }

        System.out.println("########################################################");

        // to verify overlapping booking by same person is not done for another same time slot
        // Filters: UserTypeFilter (DOCTOR), DoctorTypeFilter (GENERAL_PHYSICIAN)
        // Sorting: EarliestSlotAvailabilitySort
        // patient_id: p1
        SearchDoctorActionDetails q2_searchDoctorActionDetails = SearchQueryBuilder.buildSearchQuery(systemFilters, systemSortings, slotRepository);
        List<User> q2_doctors = userService.getDoctors(q2_searchDoctorActionDetails);

        User q2_preferredDoctor = !q2_doctors.isEmpty() ? q2_doctors.get(0) : null;
        if(q2_preferredDoctor != null){
            userService.bookSlotForPatient(q2_preferredDoctor.getId(), "p1");
        }

        System.out.println("########################################################");

        // to verify queueing of other patient for booking same doctor for same time slot
        // Filters: UserTypeFilter (DOCTOR), DoctorTypeFilter (CARDIOLOGIST)
        // Sorting: EarliestSlotAvailabilitySort
        // patient_id: p2
        SearchDoctorActionDetails q3_searchDoctorActionDetails = SearchQueryBuilder.buildSearchQuery(systemFilters, systemSortings, slotRepository);
        List<User> q3_doctors = userService.getDoctors(q3_searchDoctorActionDetails);

        User q3_preferredDoctor = !q3_doctors.isEmpty() ? q3_doctors.get(0) : null;
        if(q3_preferredDoctor != null){
            userService.bookSlotForPatient(q3_preferredDoctor.getId(), "p2");
        }

        // just another booking for DERMATOLOGIST
        SearchDoctorActionDetails q4_searchDoctorActionDetails = SearchQueryBuilder.buildSearchQuery(systemFilters, systemSortings, slotRepository);
        List<User> q4_doctors = userService.getDoctors(q4_searchDoctorActionDetails);

        User q4_preferredDoctor = !q4_doctors.isEmpty() ? q4_doctors.get(0) : null;
        if(q4_preferredDoctor != null){
            userService.bookSlotForPatient(q4_preferredDoctor.getId(), "p2");
        }

        System.out.println("########################################################");
        System.out.println("All bookings for system");
        List<Booking> allBookings = bookingRepository.getAllBookings();
        allBookings.forEach(System.out::println);

        System.out.println("########################################################");
        userService.getTrendingDoctor();

        System.out.println("########################################################");

        System.out.println(slotRepository.getAvailableSlots("d1"));
//        System.out.println(slotRepository.getAvailableSlots("d2"));
//        System.out.println(slotRepository.getAvailableSlots("d3"));
        System.out.println(slotRepository.getAvailableSlots("d4"));;
//        System.out.println(slotRepository.getAvailableSlots("d5"));
//        System.out.println(slotRepository.getAvailableSlots("d6"));
    }
}
