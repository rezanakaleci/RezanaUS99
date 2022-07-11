package com.centrilli.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //create the object of
    private static Properties properties= new Properties();

    static{
        try {
            //2. we need to open the file in java memory:  FileInputStream
            FileInputStream file= new FileInputStream("configuration.properties");
            //3.load the properties object to read value
            properties.load(file);
            //close the file
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found in the ConfigurationReader class");
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }

}
