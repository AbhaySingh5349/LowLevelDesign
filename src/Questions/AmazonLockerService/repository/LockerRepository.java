package Questions.AmazonLockerService.repository;


import Questions.AmazonLockerService.model.Locker;
import Questions.AmazonLockerService.model.Package;

public interface LockerRepository {
    Locker findLockerById(String lockerId);
    Locker findLockerByPackage(Package pkg);
    void saveLocker(Locker locker);
}
