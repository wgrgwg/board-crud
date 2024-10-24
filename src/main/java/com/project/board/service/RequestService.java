package com.project.board.service;

import com.project.board.constants.Feature;
import com.project.board.constants.Type;
import com.project.board.model.Account;
import com.project.board.model.Request;
import com.project.board.repository.RequestRepository;
import java.util.LinkedHashMap;
import java.util.Map;

public final class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request createRequest(String url, Account account) throws IllegalArgumentException {
        Type type;
        Feature feature;
        Map<String, Object> params = new LinkedHashMap<>();
        boolean isSigned = false;

        if (account != null) {
            isSigned = true;
        }

        String[] args = url.split("\\?");

        String pathPart = args[0];
        type = Type.fromText(pathPart.split("/")[1]);
        feature = Feature.fromText(pathPart.split("/")[2]);

        if (args.length == 1) {
            return requestRepository.createRequest(type, feature, null, isSigned);
        }

        String paramsPart = args[1];
        String[] keyValueList = paramsPart.split("&");

        for (String keyValue : keyValueList) {
            String key = keyValue.split("=")[0];
            String value = keyValue.split("=")[1];

            if (value.endsWith("Id")) {
                params.put(key, Integer.parseInt(value));
                continue;
            }

            params.put(key, value);
        }

        return requestRepository.createRequest(type, feature, params, isSigned);
    }
}