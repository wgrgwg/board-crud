package com.project.board.model;

import com.project.board.constants.Feature;
import com.project.board.constants.Type;
import java.util.Map;

public class Request {
    private Type type;
    private Feature feature;
    Map<String, Object> params;

    public Request(Type type, Feature feature, Map<String, Object> params) {
        this.type = type;
        this.feature = feature;
        this.params = params;
    }
}
