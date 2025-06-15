package com.restassured.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    private static Properties properties;

    static {
        loadProperties();
    }

    private ConfigurationManager() {
        // Private constructor to prevent instantiation
    }

    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = ConfigurationManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
} 