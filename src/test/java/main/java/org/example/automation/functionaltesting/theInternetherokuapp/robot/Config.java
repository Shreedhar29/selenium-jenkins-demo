package main.java.org.example.automation.functionaltesting.theInternetherokuapp.robot;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties prop = new Properties();

    static {
        try (FileReader reader = new FileReader("src/test/java/main/resources/application.properties")) {
            prop.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static String readProperty(String key) {

        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }

        String value = prop.getProperty(key);

        if (value == null) {
            throw new IllegalArgumentException("Property not found: " + key);
        }

        return value;
    }
}