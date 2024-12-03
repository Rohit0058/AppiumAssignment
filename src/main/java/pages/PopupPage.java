package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PopupPage {
    private AppiumDriver driver;
    private By popUpText = By.id("android:id/message");
    private By askMeLaterButton = By.id("android:id/button3");

    public PopupPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public String getPopUpText() {
        return driver.findElement(popUpText).getText();
    }

    public void tapAskMeLater() {
        driver.findElement(askMeLaterButton).click();
    }
}
