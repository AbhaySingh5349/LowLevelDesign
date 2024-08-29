package Questions.ElevatorSystem.model.display;

public class HallDisplay extends Display{
    @Override
    public void show() {
        // Display specific information for the hall
        System.out.println("Hall Display -> Floor: " + floor + ", Direction: " + direction);
    }
}
