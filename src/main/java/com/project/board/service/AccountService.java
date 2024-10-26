package com.project.board.service;

import com.project.board.model.Account;
import com.project.board.model.Request;
import com.project.board.repository.AccountRepository;
import java.time.LocalDateTime;

public final class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addAccount(String userId, String password, String name, String email) {
        Account account = new Account(userId, password, name, email);
        accountRepository.addAccount(account);
    }

    public void signIn(String userId, String password) throws IllegalArgumentException {
        if (Request.getSession().getSignedAccount() != null) {
            throw new IllegalArgumentException("이미 로그인된 계정이 있습니다.");
        }

        Account account = accountRepository.findAccountByUserIdPassword(userId, password);

        if (account == null) {
            throw new IllegalArgumentException("ID 혹은 비밀번호가 올바르지 않습니다.");
        }

        Request.getSession().setSignedAccount(account);
    }

    public void signout() throws IllegalArgumentException {
        if (Request.getSession().getSignedAccount() == null) {
            throw new IllegalArgumentException("로그인된 계정이 없습니다.");
        }

        Request.getSession().setSignedAccount(null);
    }

    public void updateAccount(int id, String newPassword, String newEmail) {
        Account account = accountRepository.findAccountById(id);
        if (account != null) {
            account.setPassword(newPassword);
            account.setEmail(newEmail);
            account.setEditedDateTime(LocalDateTime.now());
        }

    }

    public boolean deleteAccountById(int id) {
        return accountRepository.deleteAccountById(id);
    }

    public boolean validateAccountIdExists(int id) {
        return accountRepository.findAccountById(id) != null;
    }

    public Account findAccountById(int id) {
        return accountRepository.findAccountById(id);
    }
}
