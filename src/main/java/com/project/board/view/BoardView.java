package com.project.board.view;

import java.util.Scanner;

public final class BoardView {

    public String getCommandInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("명령어 > ");

        return scanner.nextLine();
    }

    public void displayException(String exceptionMessage){
        System.out.println("[ERROR] " + exceptionMessage);
    }

    public void displayExit(){
        System.out.println("프로그램이 종료됩니다.");
    }
}
