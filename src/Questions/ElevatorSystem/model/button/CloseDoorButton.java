package Questions.ElevatorSystem.model.button;


public class CloseDoorButton extends Button {
    @Override
    public void press() {
        setPressedStatus(true);
        System.out.println("Close Door button pressed.");
    }
}
