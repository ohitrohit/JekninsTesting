package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * This class contains all the generic methods for the property file.
 * Updated to store properties in strict alphabetical order.
 * Author: Rohit
 */
public class PropertiesFileUtilities {
    private Properties properties;
    private String propertiesFilePath;

    public PropertiesFileUtilities(String environment) {
        properties = new Properties();
        propertiesFilePath = "./src/test/resources/" + environment + ".properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(propertiesFilePath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        storePropertiesInOrder();
    }

    private void storePropertiesInOrder() {
        try {
            // Use a TreeMap to order the properties alphabetically by their keys
            TreeMap<String, String> sortedProperties = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

            for (String key : properties.stringPropertyNames()) {
                sortedProperties.put(key, properties.getProperty(key));
            }

            // Manually write the sorted properties to the file
            try (OutputStream os = new FileOutputStream(propertiesFilePath);
                 OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8")) {
                osw.write("#Properties File in Alphabetical Order\n");
                osw.write("#" + java.time.format.DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy")
                        .format(java.time.ZonedDateTime.now()) + "\n");

                for (Map.Entry<String, String> entry : sortedProperties.entrySet()) {
                    osw.write(entry.getKey() + "=" + entry.getValue() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData(String key) {
        return properties.getProperty(key);
    }
            
}