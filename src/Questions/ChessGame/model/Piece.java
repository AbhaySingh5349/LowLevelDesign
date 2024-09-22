package Questions.ChessGame.model;

import Questions.ChessGame.conditions.PieceCellOccupyBlocker;
import Questions.ChessGame.enums.Color;
import Questions.ChessGame.enums.PieceType;
import Questions.ChessGame.exceptions.InvalidMoveException;
import Questions.ChessGame.moves.PossibleMovesProvider;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private boolean isKilled;
    private final Color color;
    private final PieceType pieceType;
    private Integer numMoves; // since Pawn can take 1 or 2 steps in 1st move else can only take 1 step
    private Cell currentCell;
    private final List<PossibleMovesProvider> movesProviders; // like a piece can move in horizontal, vertical or diagonal direction

    public Piece(Color color, PieceType pieceType, List<PossibleMovesProvider> movesProviders) {
        this.isKilled = false;
        this.color = color;
        this.pieceType = pieceType;
        this.numMoves = 0;
        this.movesProviders = movesProviders;
    }

    public void setKilled(boolean killed) {
        this.isKilled = killed;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public Color getColor() {
        return color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Integer getNumMoves() {
        return numMoves;
    }

    /**
     * Method to move piece from current cell to a given cell.
     */
    public void move(Player player, Cell toCell, Board board, List<PieceCellOccupyBlocker> additionalBlockers) {
        if (isKilled) {
            throw new InvalidMoveException();
        }
        List<Cell> nextPossibleCells = nextPossibleCells(board, additionalBlockers, player);
        if (!nextPossibleCells.contains(toCell)) {
            throw new InvalidMoveException();
        }

        killPieceInCell(toCell);
        this.currentCell.setCurrentPiece(null);
        this.currentCell = toCell;
        this.currentCell.setCurrentPiece(this);
        this.numMoves++;
    }

    /**
     * Helper method to kill a piece in a given cell.
     */
    private void killPieceInCell(Cell targetCell) {
        if (targetCell.getCurrentPiece() != null) {
            targetCell.getCurrentPiece().setKilled(true);
        }
    }

    /**
     * Method which tells what are all next possible cells to which the current piece can move from the current cell.
     *
     * @param board              Board on which the piece is present.
     * @param additionalBlockers Blockers which make a cell non-occupiable for a piece.
     * @param player             Player who owns the piece.
     * @return List of all next possible cells.
     */
    public List<Cell> nextPossibleCells(Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        for (PossibleMovesProvider movesProvider : this.movesProviders) {
            List<Cell> cells = movesProvider.possibleMoves(this, board, additionalBlockers, player);
            if (cells != null) {
                result.addAll(cells);
            }
        }
        return removeDuplicates(result);
    }

    /**
     * Helper method to check if two pieces belong to same player.
     */
    public boolean isPieceFromSamePlayer(Piece piece) {
        return piece.getColor().equals(this.color);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
