package pages;

import io.appium.java_client.AppiumDriver;
import locators.HomePageLocators;

public class HomePage {
    private final AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isHomeScreenDisplayed() {
        return driver.findElement(HomePageLocators.HOME_SCREEN_TEXT).isDisplayed();
    }

    public boolean isAndroidLogoDisplayed() {
        return driver.findElement(HomePageLocators.ANDROID_LOGO).isDisplayed();
    }

    public void tapMenuItem(String menuName) {
        driver.findElement(HomePageLocators.dynamicMenuItem(menuName)).click();
    }
}
