package Questions.ElevatorSystem.strategy;

import Questions.ElevatorSystem.enums.Direction;
import Questions.ElevatorSystem.enums.ElevatorState;
import Questions.ElevatorSystem.model.ElevatorCar;

import java.util.List;

public class LookStrategy implements DispatchStrategy{
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevators, int requestedFloor, Direction direction) {
        ElevatorCar nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorCar elevator : elevators) {
            int distance = Math.abs(requestedFloor - elevator.getCurrentFloor());
            if ((elevator.getState() == ElevatorState.IDLE) ||
                (direction == Direction.UP && elevator.getState() == ElevatorState.MOVING_UP && elevator.getCurrentFloor() < requestedFloor) ||
                (direction == Direction.DOWN && elevator.getState() == ElevatorState.MOVING_DOWN && elevator.getCurrentFloor() > requestedFloor)) {
                if (distance < minDistance) {
                    nearestElevator = elevator;
                    minDistance = distance;
                }
            }
        }

        return nearestElevator;
    }
}
