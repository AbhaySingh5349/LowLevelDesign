package Questions.ElevatorSystem.model;

import Questions.ElevatorSystem.enums.ElevatorState;

public class Door {
    private boolean isOpen;

    public void open(ElevatorState state) {
        if (state == ElevatorState.IDLE) {
            isOpen = true;
            System.out.println("Door opened.");
        } else {
            System.out.println("Door can't be opened while the elevator is " + state);
        }
    }

    public void close() {
        isOpen = false;
        System.out.println("Door closed.");
    }

    public boolean isOpen() {
        return isOpen;
    }
}
