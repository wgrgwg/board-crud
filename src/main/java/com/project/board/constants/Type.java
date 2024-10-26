package com.project.board.constants;

public enum Type {
    BOARDS("boards"),
    POSTS("posts"),
    ACCOUNTS("accounts");

    private final String text;

    Type(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Type fromText(String text) {
        for (Type type : Type.values()) {
            if (type.getText().equals(text)) {
                return type;
            }
        }

        throw new IllegalArgumentException("해당하는 구분이 없습니다: " + text);
    }
}
