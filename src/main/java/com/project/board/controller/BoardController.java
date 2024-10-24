package com.project.board.controller;

import com.project.board.model.Board;
import com.project.board.model.Post;
import com.project.board.model.Request;
import com.project.board.service.BoardService;
import com.project.board.validator.Validator;
import com.project.board.view.BoardView;
import java.util.List;
import java.util.Map;

public final class BoardController {
    private BoardService boardService;
    private BoardView boardView;

    public BoardController(BoardService boardService, BoardView boardView) {
        this.boardService = boardService;
        this.boardView = boardView;
    }

    public void run(Request request) {
        switch (request.getFeature()) {
            case ADD -> createBoard();
            case VIEW -> readBoard(request.getParams());
            case EDIT -> updateBoard(request.getParams());
            case REMOVE -> deleteBoard(request.getParams());
        }
    }

    private void createBoard() {
        String name = readNameInput();

        boardService.addBoard(name);
    }

    private void readBoard(Map<String, Object> params) {
        String name = (String) params.get("boardName");
        Board board = boardService.findBoardByName(name);
        List<Post> posts = board.getPosts();
        
        boardView.displayPosts(posts);
    }

    private void updateBoard(Map<String, Object> params) {
    }

    private void deleteBoard(Map<String, Object> params) {

    }

    private String readNameInput() {
        return Validator.validateBoardName(boardView.getNameInput());
    }
}
