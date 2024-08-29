package Questions.ElevatorSystem.model.button;

import Questions.ElevatorSystem.enums.ButtonType;
import Questions.ElevatorSystem.enums.Direction;

public class ButtonFactory {
    // For buttons that don't require additional parameters
    public Button createButton(ButtonType type) {
        switch (type) {
            case OPEN_DOOR:
                return new OpenDoorButton();
            case CLOSE_DOOR:
                return new CloseDoorButton();
            default:
                throw new IllegalArgumentException("Invalid button type for this method");
        }
    }

    // For FloorButton, which requires a floor number
    public Button createButton(ButtonType type, int floorNum) {
        if (type == ButtonType.FLOOR) {
            return new FloorButton(floorNum);
        }
        throw new IllegalArgumentException("Invalid button type for this method");
    }

    // For DirectionButton, which requires a direction
    public Button createButton(ButtonType type, Direction direction) {
        if (type == ButtonType.DIRECTION) {
            return new DirectionButton(direction);
        }
        throw new IllegalArgumentException("Invalid button type for this method");
    }
}