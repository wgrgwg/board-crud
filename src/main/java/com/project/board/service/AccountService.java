package com.project.board.service;

import com.project.board.model.Account;
import com.project.board.repository.AccountRepository;

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
        Account account = accountRepository.findAccountByUserIdPassword(userId, password);

        if (account != null && AccountRepository.getSignedAccount() == null) {
            AccountRepository.setSignedAccount(account);
            return;
        }

        throw new IllegalArgumentException("ID 혹은 비밀번호가 올바르지 않습니다.");
    }
}
