package com.project.board.controller;

import com.project.board.model.Account;
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
            case SIGNUP -> createAccount();
            case SIGNIN -> signinAccount();
            case SIGNOUT -> signoutAccount();
            case DETAIL -> detail(request.getParams());
            case EDIT -> updateAccount(request.getParams());
            case REMOVE -> deleteAccount(request.getParams());
        }
    }

    public void createAccount() {
        String userId, password, name, email;

        try {
            userId = readUserIdInput();
            password = readPasswordInput();
            name = readNameInput();
            email = readEmailInput();
        } catch (IllegalArgumentException e) {
            accountView.displayException(e.getMessage());
            return;
        }

        accountService.addAccount(userId, password, name, email);
        accountView.displaySuccess("작성");
    }

    public void signinAccount() {
        String userId, password;

        try {
            userId = readUserIdInput();
            password = readPasswordInput();
            accountService.signIn(userId, password);
        } catch (IllegalArgumentException e) {
            accountView.displayException(e.getMessage());
            return;
        }

        accountView.displaySuccess("로그인");
    }

    public void signoutAccount() {
        try {
            accountService.signout();
        } catch (IllegalArgumentException e) {
            accountView.displayException(e.getMessage());
            return;
        }

        accountView.displaySuccess("로그아웃");
    }

    public void detail(Map<String, Object> params) {
        int id = (int) params.get("accountId");

        if (!accountService.validateAccountIdExists(id)) {
            accountView.displayAccountNotFound(id);
            return;
        }

        Account account = accountService.findAccountById(id);
        accountView.displayAccount(account.getId(), account.getUserId(), account.getEmail(),
                account.getCreatedDateTime());
    }

    public void updateAccount(Map<String, Object> params) {
        int id = (int) params.get("accountId");

        if (!accountService.validateAccountIdExists(id)) {
            accountView.displayAccountNotFound(id);
            return;
        }

        String password;
        String email;

        try {
            password = readPasswordInput();
            email = readEmailInput();
        } catch (IllegalArgumentException e) {
            accountView.displayException(e.getMessage());
            return;
        }

        accountService.updateAccount(id, password, email);
        accountView.displaySuccess("수정");
    }

    public void deleteAccount(Map<String, Object> params) {
        int id = (int) params.get("accountId");

        if (!accountService.validateAccountIdExists(id)) {
            accountView.displayAccountNotFound(id);
            return;
        }

        if (Request.getSession().getSignedAccount() == accountService.findAccountById(id)) {
            signoutAccount();
        }

        accountService.deleteAccountById(id);
        accountView.displaySuccess("삭제");
    }

    public String readUserIdInput() {
        return Validator.validateAccountInfo(accountView.getUserIdInput());
    }

    public String readPasswordInput() {
        return Validator.validateAccountInfo(accountView.getPasswordInput());
    }

    public String readNameInput() {
        return Validator.validateAccountInfo(accountView.getNameInput());
    }

    public String readEmailInput() {
        return Validator.validateAccountInfo(accountView.getEmailInput());
    }
}
