package org.example.utils;

import java.io.InputStream;
import java.util.Properties;

public class propertyUtil {
    private static final Properties properties = new Properties();

     static  {
        try{
            InputStream is = propertyUtil.class.getClassLoader().getResourceAsStream("api.properties");
            if(is != null) {
                properties.load(is);
                System.out.println("Properties loaded successfully.");
            } else {
                throw new RuntimeException("config.properties file not found in resources folder");
            }
            properties.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
        //System.out.println("Properties loaded successfully.");
        System.out.println(properties.getProperty("baseUrl"));
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String setProperty(String key, String value) {
        properties.setProperty(key, value);
        return properties.getProperty(key);
    }
}
