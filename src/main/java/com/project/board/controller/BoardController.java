package com.project.board.controller;

import com.project.board.constants.Command;
import com.project.board.model.Post;
import com.project.board.service.PostService;
import com.project.board.validator.Validator;
import com.project.board.view.BoardView;

public final class BoardController {

    private BoardView boardView;
    private PostService postService;

    public BoardController(BoardView boardView, PostService postService) {
        this.boardView = boardView;
        this.postService = postService;
    }

    public void run(){
        while(true){
            String command = readCommandInput();

            if(!executeCommand(Command.valueOf(command))){
                break;
            }
        }
    }

    public boolean executeCommand(Command command){
        switch (command){
            case CREATE -> createPost();
            case READ -> readPost();
            case UPDATE -> updatePost();
            case DELETE -> deletePost();
            case EXIT -> {
                boardView.displayExit();
                return false;
            }
        }
        
        return true;
    }

    private void createPost() {
        String title = readTitleInput();
        String content = readContentInput();

        postService.addPost(title, content);
    }

    private void readPost() {
        int id = readIdInput(Command.READ);

        if(!postService.validatePostIdExists(id)){
            boardView.displayPostNotFound(id);
            return;
        }

        Post post = postService.findPostById(id);

        boardView.displayPost(
            post.getId(), post.getTitle(), post.getContent()
        );
    }

    private void updatePost() {
        int id = readIdInput(Command.UPDATE);

        if(!postService.validatePostIdExists(id)){
            boardView.displayPostNotFound(id);
            return;
        }

        boardView.displayUpdate(id);
        String title = boardView.getTitleInput().trim();
        String content = boardView.getContentInput();

        postService.updatePost(id, title, content);
    }

    private void deletePost() {

    }

    public String readCommandInput(){
        String commandInput;

        while(true){
            try {
                commandInput = Validator.validateCommandInput(boardView.getCommandInput().trim());
                break;
            } catch (IllegalArgumentException e){
                boardView.displayException(e.getMessage());
            }
        }

        return commandInput;
    }

    public int readIdInput(Command command){
        return Validator.validateId(boardView.getIdInput(command).trim());
    }

    public String readTitleInput(){
        return Validator.validateTitleAndContent(boardView.getTitleInput().trim());
    }

    public String readContentInput(){
        return Validator.validateTitleAndContent(boardView.getContentInput().trim());
    }
}
