package Questions.AmazonLockerService.strategy;

import Questions.AmazonLockerService.model.Locker;
import Questions.AmazonLockerService.model.Package;

public class LockerClosedState implements LockerState{
    private Locker locker;

    public LockerClosedState(Locker locker) {
        this.locker = locker;
    }

    @Override
    public LockerState open() {
        System.out.println("Opening the locker " + locker.getLockerId());
        return new LockerOpenState(locker);
    }

    @Override
    public LockerState close() {
        System.out.println("Locker is already closed.");
        return this;
    }

    @Override
    public void pickupPackage(String code) {
        System.out.println("Locker is closed. Cannot pick up package.");
    }

    @Override
    public void returnPackage(Package pkg) {
        System.out.println("Assigning package to Locker " + locker.getLockerId());
        locker.setCurrentPackage(pkg);
        locker.setState(open());
    }

    @Override
    public boolean isClosed() {
        return true;
    }
}
