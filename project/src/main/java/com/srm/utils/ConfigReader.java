package com.srm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("config.properties not found: " + e.getMessage());
        }
    }

    public static String get(String key) {
        String value = prop.getProperty(key);
        if (value == null) throw new RuntimeException("Key not found in config: " + key);
        return value.trim();
    }
}
