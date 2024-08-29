package Questions.ElevatorSystem.model;

import Questions.ElevatorSystem.model.button.DirectionButton;
import Questions.ElevatorSystem.model.display.HallDisplay;

import java.util.List;

public class Floor {
    private final int floorNumber;
    private final List<DirectionButton> hallButtons;
    private final HallDisplay display;

    Floor(int floorNumber, List<DirectionButton> hallButtons, HallDisplay display) {
        this.floorNumber = floorNumber;
        this.hallButtons = hallButtons;
        this.display = display;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<DirectionButton> getHallButtons() {
        return hallButtons;
    }

    public HallDisplay getDisplay() {
        return display;
    }
}
