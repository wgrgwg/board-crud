package com.project.board.model;

import com.project.board.constants.Feature;
import com.project.board.constants.Type;
import java.util.List;

public class Request {
    private Type type;
    private Feature feature;
    List<Object> paramList;

    public Request(Type type, Feature feature, List<Object> paramList) {
        this.type = type;
        this.feature = feature;
        this.paramList = paramList;
    }
}
