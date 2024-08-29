package Questions.ElevatorSystem.model.display;

public class ElevatorDisplay extends Display {
    @Override
    public void show() {
        // Display specific information for the elevator
        System.out.println("Elevator Display -> Floor: " + floor + ", Direction: " + direction + ", Weight: " + weight + " kg");
    }
}