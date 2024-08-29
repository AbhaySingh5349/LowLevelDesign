package Questions.ElevatorSystem.model.display;

import Questions.ElevatorSystem.enums.Direction;

public abstract class Display {
    protected int floor;
    protected Direction direction;
    protected double weight;

    public void update(int floor, Direction direction, double weight) {
        this.floor = floor;
        this.direction = direction;
        this.weight = weight;
        show();
    }

    public abstract void show();
}
