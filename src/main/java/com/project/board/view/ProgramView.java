package com.project.board.view;

import java.util.Scanner;

public final class ProgramView {

    public String getUrlInput(String user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(user + " > ");

        return scanner.nextLine().trim();
    }

    public void displayException(String exceptionMessage) {
        System.out.println("[ERROR] " + exceptionMessage);
    }

    public void breakLine() {
        System.out.println();
    }
}
