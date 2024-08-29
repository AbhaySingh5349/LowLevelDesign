package Questions.ElevatorSystem.model;

import Questions.ElevatorSystem.enums.Direction;
import Questions.ElevatorSystem.enums.ElevatorState;
import Questions.ElevatorSystem.model.display.Display;
import Questions.ElevatorSystem.model.display.ElevatorDisplay;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCar {
    private final Door door;
    private ElevatorState state;
    private final ElevatorDisplay display;
    private final Panel panel;
    private int currentFloor;
    private Direction currentDirection;
    private double currentWeight;
    private final List<Display> observers;

    public ElevatorCar(Panel panel, ElevatorDisplay display, Door door) {
        this.observers = new ArrayList<>();
        this.currentWeight = 0;
        this.currentDirection = Direction.STILL;
        this.currentFloor = 0;
        this.panel = panel;
        this.display = display;
        this.state = ElevatorState.IDLE;
        this.door = door;
    }

    public void addObserver(Display observer) {
        observers.add(observer);
    }

    public void removeObserver(Display observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Display observer : observers) {
            observer.update(currentFloor, currentDirection, currentWeight);
        }
    }

    public void move(int newFloor, Direction direction) {
        this.currentFloor = newFloor;
        this.currentDirection = direction;
        notifyObservers();  // Notify displays of the state change

        this.state = (direction == Direction.STILL) ? ElevatorState.IDLE :
                (direction == Direction.UP) ? ElevatorState.MOVING_UP :
                        ElevatorState.MOVING_DOWN;
    }

    public void stop(int floor) {
        this.state = ElevatorState.IDLE;
        this.currentFloor = floor;
        this.currentDirection = Direction.STILL;

        notifyObservers();

        System.out.println("Elevator stopped.");
    }

    public void openDoor() {
        door.open(this.state);
    }

    public void closeDoor() {
        door.close();
    }

    public void updateWeight(double newWeight) {
        this.currentWeight = newWeight;
        notifyObservers();  // Notify displays of the weight change
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }
}
