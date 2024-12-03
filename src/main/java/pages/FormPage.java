package pages;

import io.appium.java_client.AppiumDriver;
import org.slf4j.Logger;
import utils.WaitUtils;

import static locators.FormPageLocators.*;

public class FormPage {
    AppiumDriver driver;
    private final WaitUtils waitUtils;
    private final Logger logger;

    public FormPage(AppiumDriver driver, WaitUtils waitUtils, Logger logger) {
        this.driver = driver;
        this.waitUtils = waitUtils;
        this.logger = logger;
    }

    // Method to fill the form fields
    public void fillForm(String name, String dropdownValue, boolean switchState) {
        waitUtils.waitForVisibility(inputField, 5, 500).isDisplayed();
        driver.findElement(inputField).sendKeys(name);
        driver.findElement(dropdownField).click();
        driver.findElement(selectFromDropdown).click();
        driver.findElement(switchField).click();
    }

    // Method to verify buttons' states
    public boolean isInactiveButtonDisabled() {
        return driver.findElement(inactiveButton).isEnabled();
    }

    public boolean isActiveButtonEnabled() {
        return driver.findElement(activeButton).isEnabled();
    }

    // Method to tap on the active button
    public PopupPage tapActiveButton() {
        driver.findElement(activeButton).click();
        return new PopupPage(driver); // Navigate to the pop-up page
    }
}
