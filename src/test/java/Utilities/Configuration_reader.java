package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_reader {
    private static Properties properties=new Properties();
    static {
        String pathForProperties = "Configuration.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(pathForProperties);
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Properties file not founded.");
        }
    }
    public static String getProperties (String keyWord){

        return properties.getProperty(keyWord);
    }
}
