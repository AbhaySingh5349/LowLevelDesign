package Questions.ChessGame.moves;

import Questions.ChessGame.conditions.MoveBaseCondition;
import Questions.ChessGame.conditions.PieceCellOccupyBlocker;
import Questions.ChessGame.conditions.PieceMoveFurtherCondition;
import Questions.ChessGame.model.Board;
import Questions.ChessGame.model.Cell;
import Questions.ChessGame.model.Piece;
import Questions.ChessGame.model.Player;

import java.util.ArrayList;
import java.util.List;

// Provider class which returns all the possible cells for a given type of moves.
// example: horizontal type of move will give all the cells which can be reached by making only horizontal moves.
public abstract class PossibleMovesProvider {
    Integer maxSteps;
    MoveBaseCondition moveBaseCondition;
    PieceMoveFurtherCondition pieceMoveFurtherCondition;
    PieceCellOccupyBlocker pieceCellOccupyBlocker; // whether piece can occupy cell with particular move

    public PossibleMovesProvider(Integer maxSteps, MoveBaseCondition moveBaseCondition, PieceMoveFurtherCondition pieceMoveFurtherCondition, PieceCellOccupyBlocker pieceCellOccupyBlocker) {
        this.maxSteps = maxSteps;
        this.moveBaseCondition = moveBaseCondition;
        this.pieceMoveFurtherCondition = pieceMoveFurtherCondition;
        this.pieceCellOccupyBlocker = pieceCellOccupyBlocker;
    }

    // method which actually gives all possible cells which can be reached via current type of moves
    public List<Cell> possibleMoves(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        if (moveBaseCondition.isBaseConditionFullFilled(piece)) {
            return possibleMovesAsPerCurrentType(piece, board, additionalBlockers, player);
        }
        return null;
    }

    protected abstract List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player);

    // Helper method used by all the sub types to create the list of cells which can be reached.
    protected List<Cell> findAllNextMoves(Piece piece, NextCellProvider nextCellProvider, Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        Cell nextCell = nextCellProvider.nextCell(piece.getCurrentCell());
        int numSteps = 1;
        while (nextCell != null && numSteps <= maxSteps) {
            if (checkIfCellCanBeOccupied(piece, nextCell, board, cellOccupyBlockers, player)) {
                result.add(nextCell);
            }
            if (!pieceMoveFurtherCondition.canPieceMoveFurtherFromCell(piece, nextCell, board)) {
                break;
            }

            nextCell = nextCellProvider.nextCell(nextCell);
            numSteps++;
        }
        return result;
    }

    /**
     * Helper method which checks if a given cell can be occupied by the piece or not. It makes use of list of
     * {@link PieceCellOccupyBlocker}s passed to it while checking. Also each move has one base blocker which it should
     * also check.
     */
    private boolean checkIfCellCanBeOccupied(Piece piece, Cell cell, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        if (pieceCellOccupyBlocker != null && !pieceCellOccupyBlocker.isCellAvailableForPiece(cell, piece, board, player)) {
            return false;
        }

        for (PieceCellOccupyBlocker cellOccupyBlocker : additionalBlockers) {
            if (!cellOccupyBlocker.isCellAvailableForPiece(cell, piece, board, player)) {
                return false;
            }
        }
        return true;
    }
}
