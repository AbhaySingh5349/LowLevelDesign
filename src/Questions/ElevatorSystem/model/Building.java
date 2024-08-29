package Questions.ElevatorSystem.model;

import java.util.List;

public class Building {
    private final int bottomMostFloor;
    private final int topMostFloor;
    private final List<ElevatorCar> elevators;
    private final List<Floor> floors;

    public Building(int bottomMostFloor, int topMostFloor, List<ElevatorCar> elevators, List<Floor> floors) {
        this.bottomMostFloor = bottomMostFloor;
        this.topMostFloor = topMostFloor;
        this.elevators = elevators;
        this.floors = floors;
    }

    public int getBottomMostFloor() {
        return bottomMostFloor;
    }

    public int getTopMostFloor() {
        return topMostFloor;
    }

    public List<ElevatorCar> getElevators() {
        return elevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
