package Questions.RideSharingSystem.strategy;

import Questions.RideSharingSystem.enums.RideSortPreference;
import Questions.RideSharingSystem.model.Ride;

import java.util.List;

public interface IRideSortStrategy {
    Boolean doesSupport(RideSortPreference ridePreference);
    List<Ride> matchPreference(List<Ride> rides);
}
