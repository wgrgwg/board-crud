package com.project.board.controller;

import com.project.board.model.Board;
import com.project.board.model.Post;
import com.project.board.model.Request;
import com.project.board.service.AccountService;
import com.project.board.validator.Validator;
import com.project.board.view.AccountView;
import java.util.Map;

public final class AccountController {
    private AccountService accountService;
    private AccountView accountView;

    public AccountController(AccountService accountService, AccountView accountView) {
        this.accountService = accountService;
        this.accountView = accountView;
    }

    public void run(Request request) {
        switch (request.getFeature()) {
            case ADD -> createAccount(request.getParams());
            case VIEW -> readAccount(request.getParams());
            case EDIT -> updatePost(request.getParams());
            case REMOVE -> deletePost(request.getParams());
        }
    }

    public void createAccount(Map<String, Object> params) {
        int id = (int) params.get("boardId");

        if (!boardService.validateBoardIdExists(id)) {
            postView.displayBoardNotFound(id);
            return;
        }

        Board board = boardService.findBoardById(id);
        String title;
        String content;

        try {
            title = readTitleInput();
            content = readContentInput();
        } catch (IllegalArgumentException e) {
            postView.displayException(e.getMessage());
            return;
        }

        postService.addPost(board, title, content);
        postView.displaySuccess("작성");
    }

    public void readPost(Map<String, Object> params) {
        int id = (int) params.get("postId");

        if (!postService.validatePostIdExists(id)) {
            postView.displayPostNotFound(id);
            return;
        }

        Post post = accountService.findPostById(id);
        postView.displayPost(id, post.getCreatedDateTime(), post.getEditedDateTime(), post.getTitle(),
                post.getContent());
    }

    public void updatePost(Map<String, Object> params) {
        int id = (int) params.get("postId");

        if (!postService.validatePostIdExists(id)) {
            postView.displayPostNotFound(id);
            return;
        }

        String title;
        String content;

        try {
            title = readTitleInput();
            content = readContentInput();
        } catch (IllegalArgumentException e) {
            postView.displayException(e.getMessage());
            return;
        }

        postService.updatePost(id, title, content);
        postView.displaySuccess("수정");
    }

    public void deletePost(Map<String, Object> params) {
        int id = (int) params.get("postId");

        if (!boardService.validateBoardIdExists(id)) {
            postView.displayPostNotFound(id);
            return;
        }

        postService.deletePostById(id);
        postView.displaySuccess("삭제");
    }

    public String readTitleInput() {
        return Validator.validateTitleAndContent(postView.getTitleInput());
    }

    public String readContentInput() {
        return Validator.validateTitleAndContent(postView.getContentInput());
    }
}
