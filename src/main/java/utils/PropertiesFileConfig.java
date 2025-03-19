package utils;

import base.BaseTest;

import java.io.*;
import java.util.Properties;


public class PropertiesFileConfig {

    static String currentDirectory = System.getProperty("user.dir");

//    public static void main(String[] args) {
//        currentDirectory = System.getProperty("user.dir");
//        readConfigFile();
//    }

    public static String readConfigFile() {
        Properties prop = new Properties();
        try {
//            currentDirectory = System.getProperty("user.dir");
            InputStream input = new FileInputStream(currentDirectory + "\\config.properties");
            prop.load(input);
            return prop.getProperty("browser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeConfigFile(String browserName) {
        Properties prop = new Properties();
        try {
//            currentDirectory = System.getProperty("user.dir");
            OutputStream output = new FileOutputStream(currentDirectory + "\\config.properties");
            prop.setProperty("browser", browserName);
            prop.store(output, "Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
