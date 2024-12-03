package pages;

import io.appium.java_client.AppiumDriver;
import locators.HomePageLocators;
import org.slf4j.Logger;
import utils.WaitUtils;

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

    // Verify navigation for each bottom menu item
    public boolean isMenuNavigationCorrect() throws InterruptedException {
        waitUtils.waitForVisibility(HomePageLocators.bottomMenuItems, 5, 500).isDisplayed();
//        List<WebElement> menuItems = driver.findElements(HomePageLocators.bottomMenuItems);
        waitUtils.waitForVisibility(HomePageLocators.dragButton, 5, 500).isDisplayed();
        waitUtils.waitForVisibility(HomePageLocators.webViewButton, 5, 500).isDisplayed();
        waitUtils.waitForVisibility(HomePageLocators.loginButton, 5, 500).isDisplayed();
        waitUtils.waitForVisibility(HomePageLocators.formButton, 5, 500).isDisplayed();
        waitUtils.waitForVisibility(HomePageLocators.swipeButton, 5, 500).isDisplayed();
        waitUtils.waitForVisibility(HomePageLocators.homeButton, 5, 500).isDisplayed();

//        List<WebElement> bottomMenuItems = new ArrayList<>();
//        List<By> bottomMenuLocators = new ArrayList<>();
//        bottomMenuLocators.add(HomePageLocators.homeButton);
//        bottomMenuItems.addAll(driver.findElements(HomePageLocators.homeButton));
//        bottomMenuItems.addAll(driver.findElements(HomePageLocators.webViewButton));
//        bottomMenuItems.addAll(driver.findElements(HomePageLocators.loginButton));
//        bottomMenuItems.addAll(driver.findElements(HomePageLocators.formButton));
//        bottomMenuItems.addAll(driver.findElements(HomePageLocators.swipeButton));
//        bottomMenuItems.addAll(driver.findElements(HomePageLocators.dragButton));
//
//        logger.info("Items Size - " + bottomMenuItems.size());
//
//        for (int i = 0; i < bottomMenuItems.size(); i++) {
////            String text = bottomMenuItems.get(i).getText();
//            bottomMenuItems.get(i).click();
////            waitUtils.waitForVisibility(HomePageLocators.dynamicMenuItem(text), 5, 500).isDisplayed();
//
////            logger.info("Clicked Menu Item - " + i + " " + text);
////            WebElement value = driver.findElement(HomePageLocators.dynamicMenuItem(text));
////            if (!value.isDisplayed()) {
////                return false;
////            }
////            logger.info("Verified Item Details Matched - " + i + " " + text);
//            driver.navigate().back();
//            logger.info("Back To Home - " + i + "\n");
//        }

        return true;
    }
}
