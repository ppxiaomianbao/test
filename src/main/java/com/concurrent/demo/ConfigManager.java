package com.concurrent.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo
 * @ClassName: ConfigManager
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/10/22 11:24
 * @Version: 1.0
 */
public class ConfigManager {

    private static ConfigManager configManager = null;
    private static Properties properties = null;
    String configFile = "application.properties";

    private ConfigManager() {
        InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ConfigManager getInstance() {

        if (null == configManager) {
            configManager = new ConfigManager();
        }
        return configManager;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        ConfigManager instance = ConfigManager.getInstance();
        String limx = instance.getProperty("limx");
        System.err.println(limx);
    }
}
