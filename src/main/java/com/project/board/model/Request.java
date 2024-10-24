package com.project.board.model;

import com.project.board.constants.Feature;
import com.project.board.constants.Type;
import java.util.Map;

public class Request {
    private static final Session session = new Session();
    private Type type;
    private Feature feature;
    private Map<String, Object> params;

    public Request(Type type, Feature feature, Map<String, Object> params) {
        this.type = type;
        this.feature = feature;
        this.params = params;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public static Session getSession() {
        return session;
    }
}
