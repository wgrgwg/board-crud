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
            System.out.printf("%s / %s / %s%n", post.getId(), post.getTitle(), post.getCreatedDateTime().toString());
        }
    }

    public void displayException(String exceptionMessage) {
        System.out.println("[ERROR] " + exceptionMessage);
    }

    public void displayBoardNotFound(int id) {
        System.out.println(id + "번 게시판은 존재하지 않습니다.");
    }

    public void displayBoardNotFound(String name) {
        System.out.printf("게시판 이름 %s는 존재하지 않습니다.%n", name);
    }

    public void displaySuccess(String feature) {
        System.out.printf("게시판이 성공적으로 %s되었습니다.%n", feature);
    }
}
