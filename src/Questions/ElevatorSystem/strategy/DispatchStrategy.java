package Questions.ElevatorSystem.strategy;

import Questions.ElevatorSystem.enums.Direction;
import Questions.ElevatorSystem.model.ElevatorCar;

import java.util.List;

public interface DispatchStrategy {
    ElevatorCar selectElevator(List<ElevatorCar> elevators, int requestedFloor, Direction direction);
}
