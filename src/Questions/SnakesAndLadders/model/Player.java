package Questions.SnakesAndLadders.model;

public class Player {
    private final String id;
    private Cell cell;

    public Player(String id, Cell cell) {
        this.id = id;
        this.cell = cell;
    }

    public String getId() {
        return id;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
