package edu.uek.referral.logic.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ahmed on 09.06.15.
 */
public class PropertyHandler {

    private static final String PROPERTY_FILE = "config.properties";
    private static final Properties properties = new Properties();

    public static String getProperty(String name) {
        String value = "";
        try {
            properties.load(PropertyHandler.class.getClassLoader().getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

        value = properties.getProperty(name);

        return value;
    }

}
