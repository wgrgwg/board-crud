package com.project.board.controller;

import com.project.board.model.Account;
import com.project.board.model.Request;
import com.project.board.service.RequestService;
import com.project.board.validator.Validator;
import com.project.board.view.ProgramView;

public final class ProgramController {

    private ProgramView programView;
    private RequestService requestService;
    private BoardController boardController;
    private PostController postController;
    private AccountController accountController;

    public ProgramController(ProgramView programView, RequestService requestService, BoardController boardController,
                             PostController postController, AccountController accountController) {
        this.programView = programView;
        this.requestService = requestService;
        this.boardController = boardController;
        this.postController = postController;
        this.accountController = accountController;
    }

    public void run() {
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
        boardController.run(request);
    }

    public void runPost(Request request) {
        postController.run(request);
    }

    public void runAccount(Request request) {

    }

    public String readUrlInput(Account account) {
        String url;

        while (true) {
            try {
                url = Validator.validateUrl(programView.getUrlInput(account.getUserId()));
                break;
            } catch (IllegalArgumentException e) {
                programView.displayException(e.getMessage());
            }
        }

        return url;
    }
}
