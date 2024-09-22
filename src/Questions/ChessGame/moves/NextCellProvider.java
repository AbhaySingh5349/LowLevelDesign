package Questions.ChessGame.moves;

import Questions.ChessGame.model.Cell;

public interface NextCellProvider {
    Cell nextCell(Cell cell);
}
