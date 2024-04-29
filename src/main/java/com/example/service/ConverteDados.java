package com.example.service;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ConverteDados {

    public static Map<String, String> convertStringToMap(String data) {
        Map<String, String> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(data, " ");

        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if(token.contains(":")){
                String[] keyValue = token.split(":");
                map.put(keyValue[0].replace("\"", ""),
                        keyValue[1].replace(",", ""));
            }
        }
        return map;
    }
}

