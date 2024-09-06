package Questions.AmazonLockerService.strategy;

import Questions.AmazonLockerService.model.Locker;
import Questions.AmazonLockerService.model.Package;

public class LockerOpenState implements LockerState{
    private Locker locker;

    public LockerOpenState(Locker locker) {
        this.locker = locker;
    }

    @Override
    public LockerState open() {
        System.out.println("Locker is already open.");
        return this;
    }

    @Override
    public LockerState close() {
        System.out.println("Closing the locker.");
        return new LockerClosedState(locker);
    }

    @Override
    public void pickupPackage(String code) {
        // In real scenario, verify the code
        System.out.println("Package picked up from Locker " + locker.getLockerId());
        locker.setCurrentPackage(null);
        locker.setState(close());
    }

    @Override
    public void returnPackage(Package pkg) {
        System.out.println("Cannot return package to an open locker.");
    }

    @Override
    public boolean isClosed() {
        return false;
    }
}
