package com.project.board.controller;

import com.project.board.view.BoardView;

public final class BoardController {

    private BoardView boardView;

    public BoardController(BoardView boardView) {
        this.boardView = boardView;
    }

    public void run(){

    }

    public String readCommandInput(){
        String commandInput = null;

        try {
            commandInput = boardView.getCommandInput();
        } catch (Exception e){

        }

        return commandInput;
    }
}
