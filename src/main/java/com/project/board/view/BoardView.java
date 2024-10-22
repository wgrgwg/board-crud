package com.project.board.view;

import com.project.board.constants.Command;
import java.util.Scanner;

public final class BoardView {

    public String getCommandInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("명령어 > ");

        return scanner.nextLine();
    }

    public String getIdInput(Command command){
        Scanner scanner = new Scanner(System.in);
        System.out.print("어떤 게시물을 " + command.getText() + "할까요? ");

        return scanner.nextLine();
    }

    public String getTitleInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("제목 > ");

        return scanner.nextLine();
    }

    public String getContentInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("본문 > ");

        return scanner.nextLine();
    }

    public void displayException(String exceptionMessage){
        System.out.println("[ERROR] " + exceptionMessage);
    }

    public void displayExit(){
        System.out.println("프로그램이 종료됩니다.");
    }
}
