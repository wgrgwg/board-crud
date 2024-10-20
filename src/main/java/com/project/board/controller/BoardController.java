package com.project.board.controller;

import com.project.board.validator.Validator;
import com.project.board.view.BoardView;

public final class BoardController {

    private BoardView boardView;

    public BoardController(BoardView boardView) {
        this.boardView = boardView;
    }

    public void run(){
        while(true){
            String command = readCommandInput();

            if(command.equals("종료")){
                boardView.displayExit();
                break;
            }

            System.out.println(command);
        }
    }

    public String readCommandInput(){
        String commandInput;

        while(true){
            try {
                commandInput = Validator.validateCommandInput(boardView.getCommandInput());
                break;
            } catch (IllegalArgumentException e){
                boardView.displayException(e.getMessage());
            }
        }

        return commandInput;
    }
}
