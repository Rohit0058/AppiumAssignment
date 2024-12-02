package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static final By HOME_SCREEN_TEXT = By.xpath("//*[contains(text(),'Demo app for the appium-boilerplate')]");
    public static final By ANDROID_LOGO = By.id("androidLogo");
    public static final By MENU_ITEMS = By.id("menuItem");

    public static By dynamicMenuItem(String menuName) {
        return By.xpath("//android.widget.TextView[@text='" + menuName + "']");
    }
}

