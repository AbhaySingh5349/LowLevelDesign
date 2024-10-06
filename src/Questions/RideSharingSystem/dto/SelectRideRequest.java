package Questions.RideSharingSystem.dto;

import Questions.RideSharingSystem.enums.RideSortPreference;
import Questions.RideSharingSystem.model.User;

import java.util.List;

// Old implementation before having RideFilter mechanism
/*
public class SelectRideRequest {
    User user;
    Location startLocation;
    Location endLocation;
    Integer requiredSeats;
    RidePreference ridePreference; // it is possible that we have multiple preferences, we can discuss with PM for filters

    public User getUser() {
        return user;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public Integer getRequiredSeats() {
        return requiredSeats;
    }

    public RidePreference getRidePreference() {
        return ridePreference;
    }
}
*/

public class SelectRideRequest{
    User user;
    List<RideFilter> filters;
    List<RideSort> rideSortPreferences; // we can change it's name as RideSort

    public SelectRideRequest(User user, List<RideFilter> filters, List<RideSort> rideSortPreferences) {
        this.user = user;
        this.filters = filters;
        this.rideSortPreferences = rideSortPreferences;
    }

    public User getUser() {
        return user;
    }

    public List<RideFilter> getFilters() {
        return filters;
    }

    public List<RideSort> getRidePreferences() {
        return rideSortPreferences;
    }
}