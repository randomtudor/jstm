package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesFile implements Config {
  public static final String DEFAULT_PROPERTY_PATY = "resources/%s-env.properties";
  private Properties properties;

  public ConfigPropertiesFile() {
    properties = new Properties();
    // TODO = de imbunatatit defensive code la env variable
    File propertiesFile = new File(String.format(DEFAULT_PROPERTY_PATY, System.getProperty("env")));
    String absolutePath = propertiesFile.getAbsolutePath();

    try (BufferedReader inputStream = new BufferedReader(new FileReader(absolutePath))) {
      properties.load(inputStream);
    }
    catch (IOException e) {
      System.out.println("Caught IOException: " + e.getMessage());
    }
  }

  public String getEmail() {
    return properties.getProperty("browser");
  }

  public String getPassword() {
    return properties.getProperty("environment");
  }
}