package com.project.board.model;

import com.project.board.constants.Feature;
import com.project.board.constants.Type;
import java.util.Map;

public class Request {
    private static Request request;
    private Type type;
    private Feature feature;
    private Map<String, Object> params;
    private boolean isSignIn;

    public Request(Type type, Feature feature, Map<String, Object> params, boolean isSignIn) {
        this.type = type;
        this.feature = feature;
        this.params = params;
        this.isSignIn = isSignIn;
    }
}
