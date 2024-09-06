package Questions.AmazonLockerService.repository;

import Questions.AmazonLockerService.model.Locker;
import Questions.AmazonLockerService.model.Package;

import java.util.HashMap;
import java.util.Map;

public class InMemoryLockerRepository implements LockerRepository{
    private final Map<String, Locker> lockerStorage = new HashMap<>();

    @Override
    public Locker findLockerById(String lockerId) {
        return lockerStorage.get(lockerId);
    }

    @Override
    public Locker findLockerByPackage(Package pkg) {
        for (Locker locker : lockerStorage.values()) {
            if (locker.getCurrentPackage() != null && locker.getCurrentPackage().getPackageId().equals(pkg.getPackageId())) {
                return locker;
            }
        }
        return null;
    }

    @Override
    public void saveLocker(Locker locker) {
        lockerStorage.put(locker.getLockerId(), locker);
    }

    // Utility method to add multiple lockers
    public void addLockers(Locker... lockers) {
        for (Locker locker : lockers) {
            saveLocker(locker);
        }
    }
}
