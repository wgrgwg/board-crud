package com.project.board.service;

import com.project.board.constants.Feature;
import com.project.board.constants.Type;
import com.project.board.model.Request;
import com.project.board.repository.RequestRepository;
import com.project.board.validator.Validator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request createRequest(String url) throws IllegalArgumentException {
        Type type;
        Feature feature;
        Map<String, Object> params;

        String[] args = url.split("\\?");

        String pathPart = args[0];
        type = Type.fromText(pathPart.split("/")[1]);
        feature = Feature.fromText(pathPart.split("/")[2]);

        Validator.validateTypeFeature(type, feature);

        if (args.length == 1) {
            return requestRepository.createRequest(type, feature, null);
        }

        params = stringToParams(args[1], type, feature);

        return requestRepository.createRequest(type, feature, params);
    }

    public Map<String, Object> stringToParams(String paramsPart, Type type, Feature feature)
            throws IllegalArgumentException {
        Map<String, Object> params = new LinkedHashMap<>();
        String[] keyValueList = paramsPart.split("&");

        for (String keyValue : keyValueList) {
            Validator.validateParamKeyValue(type, keyValue);

            String key = keyValue.split("=")[0];
            String value = keyValue.split("=")[1];

            Validator.validateTypeFeatureParameter(type, feature, key);

            if (key.endsWith("Id")) {
                Validator.validateNumeric(value);
                params.put(key, Integer.parseInt(value));
                continue;
            }

            params.put(key, value);
        }

        return params;
    }
}