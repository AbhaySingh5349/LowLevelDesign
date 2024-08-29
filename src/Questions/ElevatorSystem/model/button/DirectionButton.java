package Questions.ElevatorSystem.model.button;

import Questions.ElevatorSystem.enums.Direction;

public class DirectionButton extends Button {
    private final Direction direction;

    DirectionButton(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void press() {
        setPressedStatus(true);
        System.out.println(direction.toString() + " button pressed.");
    }
}
