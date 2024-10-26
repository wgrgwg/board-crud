package com.project.board.view;

import java.time.LocalDateTime;
import java.util.Scanner;

public final class PostView {
    public void displayBoardNotFound(int id) {
        System.out.println(id + "번 게시판은 존재하지 않습니다.");
    }

    public String getTitleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("제목 > ");

        return scanner.nextLine().trim();
    }

    public String getContentInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("본문 > ");

        return scanner.nextLine().trim();
    }

    public void displayException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void displaySuccess(String feature) {
        System.out.printf("게시물이 성공적으로 %s되었습니다.%n", feature);
    }

    public void displayPostNotFound(int id) {
        System.out.println(id + "번 게시글은 존재하지 않습니다.");
    }

    public void displayPost(int id, LocalDateTime createdTime, LocalDateTime editedTime, String title, String content) {
        System.out.printf("[%d]번 게시글%n", id);
        System.out.println("작성일 : " + createdTime.toString());
        System.out.println("수정일 : " + editedTime.toString());
        System.out.println("제목 : " + title);
        System.out.println("내용 : " + content);
    }
}
