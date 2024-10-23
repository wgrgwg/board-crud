package com.project.board.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Post> posts;
    private static int idCounter = 1;
    private int id;
    private String name;

    public Board(String name) {
        this.posts = new ArrayList<>();
        this.id = idCounter++;
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
