package Questions.AmazonLockerService.strategy;

import Questions.AmazonLockerService.model.Package;

public interface LockerState {
    LockerState open();
    LockerState close();
    void pickupPackage(String code);
    void returnPackage(Package pkg);
    boolean isClosed();
}
