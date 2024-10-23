package com.project.board.constants;

public enum Feature {
    ADD("add"),
    VIEW("view"),
    EDIT("edit"),
    REMOVE("remove");

    private final String text;

    Feature(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Feature fromText(String text) {
        for (Feature feature : Feature.values()) {
            if (feature.getText().equals(text)) {
                return feature;
            }
        }

        throw new IllegalArgumentException("해당하는 기능이 없습니다: " + text);
    }
}
