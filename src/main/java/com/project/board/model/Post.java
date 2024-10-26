package com.project.board.model;

import java.time.LocalDateTime;

public class Post {

    private static int idCounter = 1;
    private int id;
    private Board board;
    private String title;
    private String content;

    private LocalDateTime createdDateTime;
    private LocalDateTime editedDateTime;

    public Post(Board board, String title, String content) {
        this.id = idCounter++;
        this.board = board;
        this.title = title;
        this.content = content;
        this.createdDateTime = LocalDateTime.now();
        this.editedDateTime = LocalDateTime.now();
    }

    public Board getBoard() {
        return board;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setEditedDateTime(LocalDateTime editedDateTime) {
        this.editedDateTime = editedDateTime;
    }

    public LocalDateTime getEditedDateTime() {
        return editedDateTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
