package com.company.projects.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static Properties properties;

    static {
        loadTestData();
    }

    private static void loadTestData() {

        properties = new Properties();

        String username = System.getenv("AMAZON_USERNAME");
        String password = System.getenv("AMAZON_PASSWORD");

        if (username != null && password != null) {

            properties.setProperty("username", username);
            properties.setProperty("password", password);

        } else {

            String testDataPath = "src/test/resources/testdata.properties";

            try (FileInputStream fileInputStream =
                         new FileInputStream(testDataPath)) {

                properties.load(fileInputStream);

            } catch (IOException e) {

                throw new RuntimeException(
                        "Failed to load test data properties file", e);
            }
        }
    }

    public static String getTestData(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException(
                    "Test data is not found or empty: " + key);
        }

        return value.trim();
    }
}