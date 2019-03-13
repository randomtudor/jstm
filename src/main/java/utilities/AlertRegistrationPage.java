package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.WebElementHelper.areVisible;

public class AlertRegistrationPage extends RegistrationPage {

  public AlertRegistrationPage(final WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "div.alert-danger")
  private WebElement alertContainer;

  @Override
  public boolean isCurrent() {
    return super.isCurrent() && areVisible(this.alertContainer);
  }

  public String getAlertContainerText() {
    return this.alertContainer.getText();
  }
}
