package Questions.ElevatorSystem.model.button;

public class OpenDoorButton extends Button {
    @Override
    public void press() {
        setPressedStatus(true);
        System.out.println("Open Door button pressed.");
    }
}

