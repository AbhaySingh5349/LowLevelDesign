package Questions.ElevatorSystem.model;

import Questions.ElevatorSystem.enums.Direction;
import Questions.ElevatorSystem.strategy.DispatchStrategy;
import java.util.List;

public class ElevatorSystem {
    private final Building building;
    private DispatchStrategy strategy;

    public ElevatorSystem(Building building, DispatchStrategy strategy) {
        this.building = building;
        this.strategy = strategy;
    }

    public void setStrategy(DispatchStrategy strategy) {
        this.strategy = strategy;
    }

    public void requestElevator(int floor, Direction direction) {
        List<ElevatorCar> elevators = building.getElevators();
        ElevatorCar selectedElevator = strategy.selectElevator(elevators, floor, direction);

        if (selectedElevator != null) {
            selectedElevator.move(floor, direction);
        } else {
            System.out.println("No suitable elevator available.");
        }
    }
}
