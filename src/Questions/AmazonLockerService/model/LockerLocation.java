package Questions.AmazonLockerService.model;

import Questions.AmazonLockerService.strategy.LockerClosedState;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LockerLocation {
    private String locationId;
    private List<Locker> lockers;
    private LocalTime openTime;
    private LocalTime closeTime;

    public LockerLocation(String locationId, LocalTime openTime, LocalTime closeTime) {
        this.locationId = locationId;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.lockers = new ArrayList<>();
    }

    public List<Locker> getAvailableLockers() {
        List<Locker> availableLockers = new ArrayList<>();
        for (Locker locker : lockers) {
            if (locker.getState() instanceof LockerClosedState) {
                availableLockers.add(locker);
            }
        }
        return availableLockers;
    }

    public String getLocationId() {
        return locationId;
    }

    public boolean isLockerAccessible(LocalTime time) {
        return !time.isBefore(openTime) && !time.isAfter(closeTime);
    }

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    public List<Locker> getLockers() {
        return lockers;
    }
}
