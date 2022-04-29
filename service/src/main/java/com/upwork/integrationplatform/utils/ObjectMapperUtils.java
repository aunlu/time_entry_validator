package com.upwork.integrationplatform.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectMapperUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
            .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);

    public static String toJson(Object o) {
        Objects.requireNonNull(o);
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            String errMsg = String
                    .format("Error converting to json the object: %s with type: %s", o, o.getClass().getName());
            log.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    public static <T> T fromJsonParser(JsonParser jsonParser, Class<T> type) {
        Objects.requireNonNull(jsonParser);
        Objects.requireNonNull(type);
        try {
            return objectMapper.readValue(jsonParser, type);
        } catch (IOException e) {
            String json;
            try {
                json = jsonParser.readValueAsTree().toString();
            } catch (IOException exception) {
                throw new IllegalStateException("Error converting from unknown json to the class: " + type, e);
            }
            String errMsg = String.format("Error converting from json: %s to class: %s",
                    json, type);
            log.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    public static <T> T fromJson(Map<String, String> json, Class<T> type) {
        Objects.requireNonNull(json);
        Objects.requireNonNull(type);
        try {
            return objectMapper.convertValue(json, type);
        } catch (IllegalArgumentException e) {
            String errMsg = String.format("Error converting from json: %s to class: %s", json, type);
            log.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    public static <T> T fromJson(String json, Class<T> type) {
        Objects.requireNonNull(json);
        Objects.requireNonNull(type);
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            String errMsg = String.format("Error converting from json: %s to class: %s", json, type);
            log.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> convertType) {
        Objects.requireNonNull(json);
        Objects.requireNonNull(convertType);
        try {
            return objectMapper.readValue(json, convertType);
        } catch (IOException e) {
            String errMsg = String.format("Error converting from json: %s to TypeReference: %s", json, convertType);
            log.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    public static <T> T fromInputStream(InputStream is, Class<T> type) {
        Objects.requireNonNull(is);
        Objects.requireNonNull(type);
        try {
            return objectMapper.readValue(is, type);
        } catch (IOException e) {
            String errMsg = String.format("Error converting from input stream to class: %s", type);
            log.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }

    public static Map<String, Object> toKeyValue(Object o) {
        if (o == null) {
            return Collections.emptyMap();
        }
        try {
            return objectMapper.convertValue(o, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            String errMsg = String.format("Error converting from object to Map<String, Object>: %s", o);
            log.error(errMsg, e);
            throw new IllegalArgumentException(errMsg, e);
        }
    }
}
