package pages;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.PollingWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseTest {
    AppiumDriver driver;
    PollingWait pollingWait = new PollingWait(driver);

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
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
        pollingWait.waitForElementWithPolling(HomePageLocators.bottomMenuItems, 5, 500);
        List<WebElement> menuItems = driver.findElements(HomePageLocators.bottomMenuItems);
        List<WebElement> menuItemsText = driver.findElements(HomePageLocators.bottomMenuItemsText);

        for (int i = 0; i < menuItemsText.size(); i++) {
            String text = menuItemsText.get(i).getText();
            menuItems.get(i).click();
            pollingWait.waitForElementWithPolling(HomePageLocators.dynamicMenuItem(text), 51234, 500);
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
