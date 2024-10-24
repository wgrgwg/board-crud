package com.project.board.controller;

import com.project.board.constants.Command;
import com.project.board.model.Account;
import com.project.board.model.Board;
import com.project.board.model.Post;
import com.project.board.model.Request;
import com.project.board.service.PostService;
import com.project.board.service.RequestService;
import com.project.board.validator.Validator;
import com.project.board.view.ProgramView;
import java.util.List;

public final class ProgramController {

    private ProgramView programView;
    private PostService postService;
    private RequestService requestService;

    public ProgramController(ProgramView programView, PostService postService, RequestService requestService) {
        this.programView = programView;
        this.postService = postService;
        this.requestService = requestService;
    }

    public void run() {
        while (true) {
            String command = readCommandInput();

            if (!executeCommand(Command.fromText(command))) {
                break;
            }

            programView.breakLine();
        }
    }

    public void newRun() {
        while (true) {
            String url = readUrlInput(Request.getSession().getSignedAccount());

            Request request = requestService.createRequest(url);
            executeRequest(request);

            programView.breakLine();
        }
    }

    public void executeRequest(Request request) {
        switch (request.getType()) {
            case BOARDS -> runBoard(request);
            case POSTS -> runPost(request);
            case ACCOUNTS -> runAccount(request);
        }
    }

    public void runBoard(Request request) {

    }

    public void runPost(Request request) {

    }

    public void runAccount(Request request) {

    }

    public boolean executeCommand(Command command) {
        switch (command) {
            case CREATE -> createPost();
            case READ -> readPost();
            case UPDATE -> updatePost();
            case DELETE -> deletePost();
            case READALL -> readAllPost();
            case EXIT -> {
                programView.displayExit();
                return false;
            }
        }

        return true;
    }

    private void createPost() {
        Board board = null;
        String title = readTitleInput();
        String content = readContentInput();

        postService.addPost(board, title, content);
    }

    private void readPost() {
        int id;

        try {
            id = readIdInput(Command.READ);
        } catch (IllegalArgumentException e) {
            programView.displayException(e.getMessage());
            return;
        }

        if (!postService.validatePostIdExists(id)) {
            programView.displayPostNotFound(id);
            return;
        }

        Post post = postService.findPostById(id);

        programView.displayPost(post.getId(), post.getTitle(), post.getContent());
    }

    private void updatePost() {
        int id;

        try {
            id = readIdInput(Command.UPDATE);
        } catch (IllegalArgumentException e) {
            programView.displayException(e.getMessage());
            return;
        }

        if (!postService.validatePostIdExists(id)) {
            programView.displayPostNotFound(id);
            return;
        }

        programView.displayUpdate(id);
        String title = programView.getTitleInput().trim();
        String content = programView.getContentInput();

        if (postService.updatePost(id, title, content)) {
            programView.displaySuccess(id, Command.UPDATE);
        }
    }

    private void deletePost() {
        int id;

        try {
            id = readIdInput(Command.DELETE);
        } catch (IllegalArgumentException e) {
            programView.displayException(e.getMessage());
            return;
        }

        if (postService.deletePostById(id)) {
            programView.displaySuccess(id, Command.DELETE);
        }
    }

    public void readAllPost() {
        List<Post> posts = postService.getAllPosts();

        programView.displayPostCount(posts.size());

        for (Post post : posts) {
            programView.displayPost(post.getId(), post.getTitle(), post.getContent());
            programView.breakLine();
        }
    }

    public String readCommandInput() {
        String commandInput;

        while (true) {
            try {
                commandInput = Validator.validateCommandInput(programView.getCommandInput().trim());
                break;
            } catch (IllegalArgumentException e) {
                programView.displayException(e.getMessage());
            }
        }

        return commandInput;
    }

    public int readIdInput(Command command) {
        return Validator.validateId(programView.getIdInput(command).trim());
    }

    public String readTitleInput() {
        return Validator.validateTitleAndContent(programView.getTitleInput().trim());
    }

    public String readContentInput() {
        return Validator.validateTitleAndContent(programView.getContentInput().trim());
    }

    public String readUrlInput(Account account) {
        return Validator.validateUrl(programView.getUrlInput(account.getUserId()).trim());
    }
}
