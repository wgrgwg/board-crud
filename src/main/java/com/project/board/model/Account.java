package com.project.board.model;

import java.time.LocalDateTime;

public class Account {
    private static int idCounter = 1;
    private int id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private LocalDateTime createdDateTime;
    private LocalDateTime editedDateTime;

    public Account(String userId, String password, String name, String email) {
        this.id = idCounter++;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.createdDateTime = LocalDateTime.now();
        this.editedDateTime = LocalDateTime.now();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEditedDateTime(LocalDateTime editedDateTime) {
        this.editedDateTime = editedDateTime;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public LocalDateTime getEditedDateTime() {
        return editedDateTime;
    }

    @Override
    public String toString() {
        return String.format(
                "[%d]번 회원%n계정 : %s%n이메일 : %s%n가입일 : %s",
                id, userId, email, createdDateTime.toString()
        );
    }
}
