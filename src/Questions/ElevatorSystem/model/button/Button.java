package Questions.ElevatorSystem.model.button;

public abstract class Button {
    private boolean pressedStatus;

    public boolean isPressed() {
        return pressedStatus;
    }

    public void setPressedStatus(boolean status) {
        this.pressedStatus = status;
    }

    public abstract void press();
}
