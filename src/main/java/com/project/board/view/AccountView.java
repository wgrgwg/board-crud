package com.project.board.view;

import java.time.LocalDateTime;
import java.util.Scanner;

public final class AccountView {

    public String getUserIdInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("계정(ID) > ");

        return scanner.nextLine().trim();
    }

    public String getPasswordInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("비밀번호 > ");

        return scanner.nextLine().trim();
    }

    public String getNameInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름 > ");

        return scanner.nextLine().trim();
    }

    public String getEmailInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이메일 > ");

        return scanner.nextLine().trim();
    }

    public void displayException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void displaySuccess(String feature) {
        System.out.printf("회원이 성공적으로 %s되었습니다.%n", feature);
    }

    public void displayAccountNotFound(int id) {
        System.out.println(id + "번 회원은 존재하지 않습니다.");
    }

    public void displayAccount(int id, String userId, String email, LocalDateTime createdTime) {
        System.out.printf("[%d]번 회원%n", id);
        System.out.println("계정 : " + userId);
        System.out.println("이메일 : " + email);
        System.out.println("가입일 : " + createdTime.toString());
    }
}
