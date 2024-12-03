package pages;

import io.appium.java_client.AppiumDriver;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utils.WaitUtils;

import java.util.Arrays;
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

    // Method to tap on the Home button
    public void tapHomeButton() {
        driver.findElement(HomePageLocators.homeButton).click();
    }

    // Method to tap on the Form button
    public void tapFormButton() {
        driver.findElement(HomePageLocators.formButton).click();
    }

    public boolean isMenuNavigationCorrect() {
        List<By> bottomMenuLocators = Arrays.asList(
                HomePageLocators.webViewButton,
                HomePageLocators.loginButton,
                HomePageLocators.formButton,
                HomePageLocators.swipeButton,
                HomePageLocators.dragButton
        );

        for (By menuLocator : bottomMenuLocators) {
            // Wait for the menu item to be visible and click it
            WebElement menuItem = waitUtils.waitForVisibility(menuLocator, 5, 500);
            if (!menuItem.isDisplayed()) {
                logger.error("Menu item not displayed: " + menuLocator);
                return false;
            }
            menuItem.click();
            logger.info("Clicked menu item: " + menuLocator);

            // Validate the expected screen is displayed
            By expectedScreenLocator = getExpectedScreenLocator(menuLocator);
            WebElement expectedScreenElement = waitUtils.waitForVisibility(expectedScreenLocator, 5, 500);
            if (!expectedScreenElement.isDisplayed()) {
                logger.error("Expected screen not displayed after clicking: " + menuLocator);
                return false;
            }
            logger.info("Verified navigation to screen: " + expectedScreenLocator);

            // Navigate back to the home screen
            driver.navigate().back();
            logger.info("Navigated back to the home screen");
        }
        return true;
    }

    private By getExpectedScreenLocator(By menuLocator) {
        if (menuLocator.equals(HomePageLocators.webViewButton)) {
            return HomePageLocators.webViewScreen;
        } else if (menuLocator.equals(HomePageLocators.loginButton)) {
            return HomePageLocators.loginScreen;
        } else if (menuLocator.equals(HomePageLocators.formButton)) {
            return HomePageLocators.formScreen;
        } else if (menuLocator.equals(HomePageLocators.swipeButton)) {
            return HomePageLocators.swipeScreen;
        } else if (menuLocator.equals(HomePageLocators.dragButton)) {
            return HomePageLocators.dragScreen;
        }
        throw new IllegalArgumentException("Unknown menu locator: " + menuLocator);
    }

}
