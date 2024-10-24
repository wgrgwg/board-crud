package com.project.board.view;

import com.project.board.model.Post;
import java.util.List;
import java.util.Scanner;

public final class BoardView {
    public String getNameInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("게시판 이름 > ");

        return scanner.nextLine().trim();
    }

    public void displayPosts(List<Post> posts) {
        System.out.println("게시글 목록");
        for (Post post : posts) {
            System.out.println(
                    String.format("%s / %s / %s", post.getId(), post.getTitle(), post.getCreatedDateTime().toString()));
        }
    }
}
