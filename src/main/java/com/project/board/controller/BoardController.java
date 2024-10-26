package com.project.board.controller;

import com.project.board.model.Board;
import com.project.board.model.Post;
import com.project.board.model.Request;
import com.project.board.service.BoardService;
import com.project.board.service.PostService;
import com.project.board.validator.Validator;
import com.project.board.view.BoardView;
import java.util.List;
import java.util.Map;

public final class BoardController {
    private BoardService boardService;
    private BoardView boardView;
    private PostService postService;

    public BoardController(BoardService boardService, BoardView boardView, PostService postService) {
        this.boardService = boardService;
        this.boardView = boardView;
        this.postService = postService;
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
        String name;

        try {
            name = readNameInput();
        } catch (IllegalArgumentException e) {
            boardView.displayException(e.getMessage());
            return;
        }

        boardService.addBoard(name);
        boardView.displaySuccess("작성");
    }

    private void readBoard(Map<String, Object> params) {
        String name = (String) params.get("boardName");

        if (!boardService.validateBoardNameExists(name)) {
            boardView.displayBoardNotFound(name);
            return;
        }

        Board board = boardService.findBoardByName(name);
        List<Post> posts = board.getPosts();

        boardView.displayPosts(posts);
    }

    private void updateBoard(Map<String, Object> params) {
        int id = (int) params.get("boardId");

        if (!boardService.validateBoardIdExists(id)) {
            boardView.displayBoardNotFound(id);
            return;
        }

        String newName;

        try {
            newName = readNameInput();
        } catch (IllegalArgumentException e) {
            boardView.displayException(e.getMessage());
            return;
        }

        boardService.updateBoard(id, newName);
        boardView.displaySuccess("수정");
    }

    private void deleteBoard(Map<String, Object> params) {
        int id = (int) params.get("boardId");

        if (!boardService.validateBoardIdExists(id)) {
            boardView.displayBoardNotFound(id);
            return;
        }

        Board board = boardService.findBoardById(id);
        List<Post> posts = board.getPosts();

        for (Post post : posts) {
            postService.deletePostById(post.getId());
        }

        boardService.deleteBoardById(id);
        boardView.displaySuccess("삭제");
    }

    private String readNameInput() {
        return Validator.validateBoardName(boardView.getNameInput());
    }
}
