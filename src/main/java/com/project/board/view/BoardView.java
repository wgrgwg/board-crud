package com.project.board.view;

import com.project.board.constants.Command;
import java.util.Scanner;

public final class BoardView {

    public String getCommandInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("명령어 > ");

        return scanner.nextLine().trim();
    }

    public String getIdInput(Command command){
        Scanner scanner = new Scanner(System.in);
        System.out.print("어떤 게시물을 " + command.getText() + "할까요? ");

        return scanner.nextLine().trim();
    }

    public String getTitleInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("제목 > ");

        return scanner.nextLine().trim();
    }

    public String getContentInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("본문 > ");

        return scanner.nextLine().trim();
    }

    public void displayException(String exceptionMessage){
        System.out.println("[ERROR] " + exceptionMessage);
    }

    public void displayExit(){
        System.out.println("프로그램이 종료됩니다.");
    }

    public void displayPost(int id, String title, String content) {
        System.out.println(id+"번 게시물");
        System.out.println("제목 : " + title);
        System.out.println("내용 : " + content);
    }

    public void displayPostNotFound(int id){
        System.out.println(id + "번 게시글은 존재하지 않습니다.");
    }

    public void displayUpdate(int id){
        System.out.println(id + "번 게시글을 수정합니다.");
    }

    public void displaySuccess(int id, Command command){
        System.out.println(id +"번 게시물이 성공적으로 " + command.getText() + "되었습니다!");
    }
}
