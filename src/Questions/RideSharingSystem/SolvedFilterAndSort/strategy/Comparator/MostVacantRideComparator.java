package Questions.RideSharingSystem.SolvedFilterAndSort.strategy.Comparator;

import Questions.RideSharingSystem.SolvedFilterAndSort.model.Ride;

import java.util.Comparator;

public class MostVacantRideComparator implements Comparator<Ride> {
    @Override
    public int compare(Ride r1, Ride r2) {
        return Integer.compare(r2.getAvailableSeats(), r1.getAvailableSeats()); // descending
    }
}