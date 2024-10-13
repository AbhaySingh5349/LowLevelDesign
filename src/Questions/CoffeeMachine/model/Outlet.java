package Questions.CoffeeMachine.model;

import Questions.CoffeeMachine.enums.OutletStatus;

public class Outlet {
    private OutletStatus status;

    public Outlet(OutletStatus status) {
        this.status = status;
    }

    public OutletStatus getStatus() {
        return status;
    }

    public void setStatus(OutletStatus status) {
        this.status = status;
    }
}
