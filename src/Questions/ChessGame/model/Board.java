package Questions.ChessGame.model;

import Questions.ChessGame.enums.PieceType;

import java.util.List;

public class Board {
    int boardSize;
    Cell[][] cells;

    public Board(int boardSize, Cell[][] cells) {
        this.boardSize = boardSize;
        this.cells = cells;
    }

    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() - 1);
    }

    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() + 1);
    }

    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY());
    }

    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY());
    }

    public Cell getCellAtLocation(int x, int y) {
        if (x >= boardSize || x < 0) {
            return null;
        }
        if (y >= boardSize || y < 0) {
            return null;
        }

        return cells[x][y];
    }

    // to check if player's King is getting killed by opponent or not
    public boolean isPlayerOnCheck(Player player) {
//        return checkIfPieceCanBeKilled(player.getPiece(PieceType.KING), kingCheckEvaluationBlockers(), player);

        return false;
    }

    // check if opponent's piece is getting killed
//    public boolean checkIfPieceCanBeKilled(Piece targetPiece, List<PieceCellOccupyBlocker> cellOccupyBlockers, Player player) {
//        for (int i = 0; i < boardSize; i++) {
//            for (int j = 0; j < boardSize; j++) {
//                Piece currentPiece = getCellAtLocation(i, j).getCurrentPiece();
//                if (currentPiece != null && !currentPiece.isPieceFromSamePlayer(targetPiece)) {
//                    List<Cell> nextPossibleCells = currentPiece.nextPossibleCells(this, cellOccupyBlockers, player);
//                    if (nextPossibleCells.contains(targetPiece.getCurrentCell())) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
}
