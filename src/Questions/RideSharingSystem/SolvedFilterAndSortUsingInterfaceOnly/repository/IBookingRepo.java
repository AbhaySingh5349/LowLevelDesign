package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;


import Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.model.Booking;

public interface IBookingRepo {
    void add(Booking booking);
    Booking getById(String id);
}
