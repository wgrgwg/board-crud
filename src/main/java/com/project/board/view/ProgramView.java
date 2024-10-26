package com.project.board.view;

import java.util.Scanner;

public final class ProgramView {

    public String getUrlInput(String user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(user + " > ");

        return scanner.nextLine().trim();
    }

    public void displayException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void breakLine() {
        System.out.println();
    }

    public void displayNoParamException() {
        System.out.println("파라미터를 입력해주세요.");
    }
}
