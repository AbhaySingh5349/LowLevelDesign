package Questions.SnakesAndLadders.service;


import Questions.SnakesAndLadders.model.Board;
import Questions.SnakesAndLadders.model.Cell;
import Questions.SnakesAndLadders.repository.CellRepository;

import java.util.Scanner;

public class BoardService {
    private Board board;
    private CellRepository cellRepository;

    public BoardService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    public void initializeBoard(Scanner scanner){
        System.out.println("Enter Board rowCount colCount");
        String[] boardInp = scanner.nextLine().trim().split(" ");

        int rowCount = Integer.parseInt(boardInp[1]);
        int colCount = Integer.parseInt(boardInp[2]);

        board = new Board(rowCount, colCount);

        int cellCount = rowCount * colCount;
        for(int i=0;i<=cellCount;i++){
            Cell cell = new Cell(i);
            cellRepository.add(cell);
        }
    }

    public int getSize(){
        return board.getRowNum() * board.getColNum();
    }
}
