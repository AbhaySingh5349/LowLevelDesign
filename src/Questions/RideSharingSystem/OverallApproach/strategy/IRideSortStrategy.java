package Questions.RideSharingSystem.OverallApproach.strategy;

import Questions.RideSharingSystem.OverallApproach.enums.RideSortPreference;
import Questions.RideSharingSystem.OverallApproach.model.Ride;

import java.util.List;

public interface IRideSortStrategy {
    Boolean doesSupport(RideSortPreference ridePreference);
    List<Ride> matchPreference(List<Ride> rides);
}
