package Questions.ElevatorSystem;

import Questions.ElevatorSystem.enums.ButtonType;
import Questions.ElevatorSystem.enums.Direction;
import Questions.ElevatorSystem.model.*;
import Questions.ElevatorSystem.model.button.Button;
import Questions.ElevatorSystem.model.button.ButtonFactory;
import Questions.ElevatorSystem.model.display.ElevatorDisplay;
import Questions.ElevatorSystem.model.display.HallDisplay;
import Questions.ElevatorSystem.strategy.LookStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ElevatorDisplay elevatorDisplay = new ElevatorDisplay();
        HallDisplay hallDisplay = new HallDisplay();

        // Create Elevator Buttons
        List<Button> elevatorButtons = new ArrayList<>();
        ButtonFactory buttonFactory = new ButtonFactory();

        Button firstFloorButton = buttonFactory.createButton(ButtonType.FLOOR, 1);
        Button thirdFloorButton = buttonFactory.createButton(ButtonType.FLOOR, 3);
        Button upButton = buttonFactory.createButton(ButtonType.DIRECTION, Direction.UP);
        Button openDoorButton = buttonFactory.createButton(ButtonType.OPEN_DOOR);
        Button closeDoorButton = buttonFactory.createButton(ButtonType.CLOSE_DOOR);

        elevatorButtons.add(firstFloorButton);
        elevatorButtons.add(thirdFloorButton);
        elevatorButtons.add(openDoorButton);
        elevatorButtons.add(closeDoorButton);

        // Create Elevator Panel
        Panel elevatorPanel = new Panel(elevatorButtons);

        // Create Door
        Door elevatorDoor = new Door();

        // Create Elevator Cars
        ElevatorCar elevatorCar = new ElevatorCar(elevatorPanel, elevatorDisplay, elevatorDoor);

        // Register Displays with the Elevator Car
        elevatorCar.addObserver(elevatorDisplay);
        elevatorCar.addObserver(hallDisplay);

        // Create Elevator System with Look strategy
        List<ElevatorCar> elevatorCars = Arrays.asList(elevatorCar);

        Building building = new Building(1, 10, elevatorCars, Arrays.asList());
        ElevatorSystem elevatorSystem = new ElevatorSystem(building, new LookStrategy());

        // Simulate requests
        elevatorSystem.requestElevator(2, Direction.UP);

        elevatorCar.updateWeight(450);

        elevatorSystem.requestElevator(1, Direction.DOWN);
    }
}
