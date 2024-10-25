package com.project.board.repository;

import com.project.board.model.Account;
import java.util.ArrayList;
import java.util.List;

public final class AccountRepository {
    private static Account signedAccount = null;
    private final List<Account> accounts = new ArrayList<>();

    public static Account getSignedAccount() {
        return signedAccount;
    }

    public static void setSignedAccount(Account signedAccount) {
        AccountRepository.signedAccount = signedAccount;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccountById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }

        return null;
    }

    public Account findAccountByUserIdPassword(String userId, String password) {
        for (Account account : accounts) {
            if (account.getUserId().equals(userId) && account.getPassword().equals(password)) {
                return account;
            }
        }

        return null;
    }

    public boolean deleteAccountById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                accounts.remove(account);
                return true;
            }
        }

        return false;
    }
}
