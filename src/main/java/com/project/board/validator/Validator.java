package com.project.board.validator;

import com.project.board.constants.Command;

public final class Validator {

    public static String validateCommandInput(String input) throws IllegalArgumentException {
        checkCommand(input);

        return input;
    }

    public static int validateId(String input) throws IllegalArgumentException {
        String number = input.replaceAll("[^0-9]", "");

        return Integer.parseInt(number);
    }

    public static String validateTitleAndContent(String input) throws IllegalArgumentException {
        if(input.isBlank() || input.isEmpty()){
            throw new IllegalArgumentException("빈 문자열입니다.");
        }

        return input;
    }

    private static void checkCommand(String input) {
        if(!isValidCommand(input)){
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
}
