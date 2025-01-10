package Questions.SnakesAndLadders.model;

public class Board {
    private final int rowNum;
    private final int colNum;

    public Board(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }
}
