package com.lava.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


public class PropertyReader {

    public static HashMap<String,String> getPropValues(String file) {
        InputStream inputStream;
        HashMap<String,String> result = new HashMap<String, String>();

        try {
            Properties prop = new Properties();
            String propFileName = file;
            inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(propFileName);
            //inputStream = new FileInputStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            // get the property values
            Set propNames = prop.stringPropertyNames();
            Iterator<String> iterator = propNames.iterator();
            while (iterator.hasNext())
            {
                String key = iterator.next();
                result.put(key , prop.getProperty(key));
            }

            inputStream.close();


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return result;
    }
}