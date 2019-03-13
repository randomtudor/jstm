package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.helper.Validate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** General helper class */
public class Utilities {
  //public static final String APP_FILE = "./app.properties";
  public static final String APP_FILE = "src/test/resources/app.properties";
  private static final Logger LOG = Logger.getLogger(Class.class.getName());
  private static final String SLEEP_INTERRUPTED = "Sleep interrupted!";

  public static String getPropertyValue(String propertyName) {
    Validate.notNull(propertyName, "System property name cannot be null or blank");

    final String propertyValue = new ReadPropFile().getPropertyValue(APP_FILE).getProperty(propertyName);

    if (StringUtils.isNotBlank(propertyValue)) {
      return propertyValue;
    }
    else {
      throw new IllegalArgumentException(
          String.format("Environment variable '%s' does not exist or is blank", propertyValue));
    }
  }

  /*
  public static Properties getPropertyFileContent(String propertiesFileName) {
    return new ReadPropFile().getPropertiesValue(propertiesFileName);
  }

  public static String getPropertyFromAppProp(String prop) {
    return getPropertyValue(getPropertyFileContent(APP_FILE), prop);
  }
  */

  public static Object executeScript(
      final WebDriver driver, final String script, final Object... args) {
    try {
      return ((JavascriptExecutor) driver).executeScript(script, args);
    } catch (final WebDriverException ex) {
      throw new WebDriverException("Could not execute JavaScript command '" + script + "'", ex);
    }
  }

  public static void sleep(final long timeoutMs, final boolean swallowExceptions) {
    try {
      Thread.sleep(timeoutMs);
    } catch (final InterruptedException e) {
      if (swallowExceptions) {
        LOG.info(SLEEP_INTERRUPTED);
      } else {
        throw new IllegalStateException(SLEEP_INTERRUPTED, e);
      }
    }
  }

  public static String randomString(int length, boolean letters, boolean numbers) {
    return RandomStringUtils.random(length, letters, numbers);
  }

  public static String randomNumber(int start, int end) {
    List<Integer> inclusiveRange =
        IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    return inclusiveRange.get(new Random().nextInt(inclusiveRange.size())).toString();
  }
}
