package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/** Helper class for working with the page's elements */
public class WebElementHelper {
  private static final Logger LOG = Logger.getLogger(Class.class.getName());

  public static void setFieldValue(final WebElement element, final String text) {
    element.click();
    element.clear();
    element.sendKeys(text);
  }

  public static void selectRadioField(final WebElement element) {
    element.click();
  }

  public static void selectFieldValue(final WebElement element, final String value) {
    final Select select = new Select(element);
    select.selectByValue(value);
  }

  public static void logOut(final WebElement element) {
    element.click();
  }

  public static boolean isElementDisplayed(final WebElement element) {
    try {
      if (element != null && element.isDisplayed()) {
        return true;
      }
    } catch (final Exception e) {
      return false;
    }
    return false;
  }

  public static boolean areVisible(final WebElement... elements) {
    final List<WebElement> webElements = Arrays.asList(elements);
    final List<WebElement> elementsNotVisible = new ArrayList<>();

    webElements.forEach(
        webElement -> {
          if (!isElementDisplayed(webElement)) {
            elementsNotVisible.add(webElement);
          }
        });

    if (!elementsNotVisible.isEmpty()) {
      LOG.warning(
          String.format("The following elements are not visible in page: %s", elementsNotVisible));
    }
    return elementsNotVisible.isEmpty();
  }
}
