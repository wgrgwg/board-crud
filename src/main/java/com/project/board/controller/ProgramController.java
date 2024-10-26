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

            try {
                Request request = requestService.createRequest(url);
                executeRequest(request);
            } catch (IllegalArgumentException e) {
                programView.displayException(e.getMessage());
            }

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
        accountController.run(request);
    }

    public String readUrlInput(Account account) {
        String url;
        String signedUserName = "손님";
        if (account != null) {
            signedUserName = account.getName();
        }

        while (true) {
            try {
                url = Validator.validateUrl(programView.getUrlInput(signedUserName));
                break;
            } catch (IllegalArgumentException e) {
                programView.displayException(e.getMessage());
                programView.breakLine();
            }
        }

        return url;
    }
}
