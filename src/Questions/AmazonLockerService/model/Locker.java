package Questions.AmazonLockerService.model;

import Questions.AmazonLockerService.enums.Size;
import Questions.AmazonLockerService.strategy.LockerClosedState;
import Questions.AmazonLockerService.strategy.LockerState;

public class Locker {
    private final String lockerId;
    private final Size size;
    private LockerState state;
    private Package currentPackage;

    public Locker(String lockerId, Size size) {
        this.lockerId = lockerId;
        this.size = size;
        this.state = new LockerClosedState(this);
    }

    public void assignPackage(Package pkg) {
        if (pkg.getSize().ordinal() <= size.ordinal()) {
            this.currentPackage = pkg;
            this.state.open();
        } else {
            throw new IllegalArgumentException("Package too large for locker.");
        }
    }

    public Size getSize() {
        return size;
    }

    public String getLockerId() {
        return lockerId;
    }

    public LockerState getState() {
        return state;
    }

    public void setState(LockerState state) {
        this.state = state;
    }

    public Package getCurrentPackage() {
        return currentPackage;
    }

    public void setCurrentPackage(Package currentPackage) {
        this.currentPackage = currentPackage;
    }
}