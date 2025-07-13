package com.payments.parser;

import java.util.HashMap;
import java.util.Map;

public class GenericMessage {
    private Map<String, Object> data = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println("key: " + key + " value: " + value);
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public Map<String, Object> getData() {
        return data;
    }
}
