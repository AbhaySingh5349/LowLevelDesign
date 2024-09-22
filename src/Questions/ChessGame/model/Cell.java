package Questions.ChessGame.model;

public class Cell {

    private final Integer x;
    private final Integer y;
    private Piece currentPiece;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.currentPiece = null;
    }

    public boolean isFree() {
        return currentPiece == null;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }
}
