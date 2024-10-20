package com.project.board;

import com.project.board.controller.BoardController;
import com.project.board.view.BoardView;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        BoardView boardView = new BoardView();
        BoardController boardController = new BoardController(boardView);

        boardController.run();
    }
}
