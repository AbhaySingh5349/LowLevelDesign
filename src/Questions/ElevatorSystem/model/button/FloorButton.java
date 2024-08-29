package Questions.ElevatorSystem.model.button;

public class FloorButton extends Button {
    private final int floorNumber;

    public FloorButton(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void press() {
        setPressedStatus(true);
        System.out.println("Floor " + floorNumber + " button pressed.");
    }
}