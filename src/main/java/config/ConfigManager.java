package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("application.properties not found in src/main/resources");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static String get(String key) {
        String val = props.getProperty(key);
        if (val == null || val.isBlank()) {
            throw new RuntimeException("Missing property: " + key);
        }
        return val.trim();
    }
}