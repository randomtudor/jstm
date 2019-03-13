package utilities;

import java.io.*;
import java.util.Properties;

public class ReadPropFile {

  public Properties getPropertiesValue(String propertiesFile) {

    InputStream inputStream = null;
    Properties prop = new Properties();
    try {
      inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile);
      if (inputStream != null) {
        prop.load(inputStream);
      } else {
        throw new FileNotFoundException(
            "property file '" + propertiesFile + "' not found in the classpath");
      }
    }
    catch (Exception e) {
      throw e;
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return prop;
    }
  }

  public Properties getPropertyValue(String file) {
    File propertiesFile = new File("src/testTT/resources/app.properties");
    String absolutePath = propertiesFile.getAbsolutePath();
    Properties prop = new Properties();

    try (BufferedReader inputStream = new BufferedReader(new FileReader(absolutePath))) {
      prop.load(inputStream);
    }
    catch (IOException e) {
      System.out.println("Caught IOException: " + e.getMessage());
    }

    return prop;
  }
}
