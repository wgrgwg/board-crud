package com.project.board.constants;

public enum Command {
    CREATE("작성"),
    READ("조회"),
    UPDATE("수정"),
    DELETE("삭제"),
    READALL("목록"),
    EXIT("종료");

    private final String text;

    Command(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
