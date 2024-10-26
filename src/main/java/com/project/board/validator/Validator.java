package com.project.board.validator;

import com.project.board.constants.Command;
import com.project.board.constants.Constant;
import com.project.board.constants.Type;

public final class Validator {

    public static String validateTitleAndContent(String input) throws IllegalArgumentException {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }

        return input;
    }

    public static String validateAccountInfo(String input) throws IllegalArgumentException {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백 문자를 포함할 수 없습니다.");
        }

        return input;
    }

    private static void checkCommand(String input) {
        if (!isValidCommand(input)) {
            throw new IllegalArgumentException("존재하지 않는 명령어 입니다.");
        }
    }

    public static boolean isValidCommand(String inputText) {
        for (Command command : Command.values()) {
            if (command.getText().equals(inputText)) {
                return true;
            }
        }
        return false;
    }

    public static String validateUrl(String input) throws IllegalArgumentException {
        String[] parts = input.split("/");

        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백 문자가 포함된 URL");
        }

        if (parts.length != 3) {
            throw new IllegalArgumentException("유효하지 않은 URL");
        }

        for (int i = 1; i < parts.length; i++) {
            if (parts[i].isEmpty()) {
                throw new IllegalArgumentException("유효하지 않은 URL");
            }
        }

        return input;
    }

    public static String validateBoardName(String input) throws IllegalArgumentException {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("게시판 제목엔 공백 문자가 포함될 수 없습니다.");
        }

        return input;
    }

    public static void validateParamKeyValue(Type type, String keyValue) throws IllegalArgumentException {
        if (keyValue.split("=").length < 2) {
            throw new IllegalArgumentException("올바르지 않은 파라미터입니다.");
        }

        String key = keyValue.split("=")[0];

        if (!Constant.PARAM_KEYS.get(type).contains(key)) {
            throw new IllegalArgumentException("올바르지 않은 파라미터 key입니다.");
        }
    }
}
