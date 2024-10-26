package com.project.board.repository;

import com.project.board.constants.Feature;
import com.project.board.constants.Type;
import com.project.board.model.Request;
import java.util.Map;

public final class RequestRepository {

    public Request createRequest(Type type, Feature feature, Map<String, Object> params) {
        return new Request(type, feature, params);
    }
}
