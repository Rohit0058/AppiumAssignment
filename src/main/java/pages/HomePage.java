package pages;

import io.appium.java_client.AppiumDriver;
import locators.HomePageLocators;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utils.WaitUtils;

import java.util.List;

public class HomePage {
    AppiumDriver driver;
    private final WaitUtils waitUtils;
    private final Logger logger;

    public HomePage(AppiumDriver driver, WaitUtils waitUtils, Logger logger) {
        this.driver = driver;
        this.waitUtils = waitUtils;
        this.logger = logger;
    }

    // Verify if home screen text is displayed
    public boolean isHomeScreenDisplayed() {
        return driver.findElement(HomePageLocators.homeScreenText).isDisplayed();
    }

    // Verify if the Android logo is displayed
    public boolean isAndroidLogoDisplayed() {
        return driver.findElement(HomePageLocators.androidLogo).isDisplayed();
    }

    // Get the count of bottom menu items
    public int getMenuItemCount() {
        return driver.findElements(HomePageLocators.bottomMenuItems).size();
    }

    // Verify navigation for each bottom menu item
    public boolean isMenuNavigationCorrect() throws InterruptedException {
        waitUtils.waitForVisibility(HomePageLocators.bottomMenuItems, 5, 500).isDisplayed();
        List<WebElement> menuItems = driver.findElements(HomePageLocators.bottomMenuItems);
        List<WebElement> menuItemsText = driver.findElements(HomePageLocators.bottomMenuItemsText);

        for (int i = 0; i < menuItemsText.size(); i++) {
            String text = menuItemsText.get(i).getText();
            menuItems.get(i).click();
            waitUtils.waitForVisibility(HomePageLocators.dynamicMenuItem(text), 5, 500).isDisplayed();

            logger.info("Clicked Menu Item - " + i + " " + text);
            WebElement value = driver.findElement(HomePageLocators.dynamicMenuItem(text));
            if (!value.isDisplayed()) {
                return false;
            }
            logger.info("Verified Item Details Matched - " + i + " " + text);
            driver.navigate().back();
            logger.info("Back To Home - " + i + "\n");
        }

        return true;
    }
}
