package pages;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HomePage extends BaseTest {
    AppiumDriver driver;

    // Locators
    private By homeScreenText = By.xpath("//android.widget.TextView[@text=\"Products\"]\n");
    private By androidLogo = By.xpath("//android.view.ViewGroup[@content-desc=\"longpress reset app\"]/android.widget.ImageView");
    private By bottomMenuItems = By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])");
    private By bottomMenuItemsText = By.xpath("(//android.widget.TextView[@content-desc=\"store item text\"])");

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        List<WebElement> menuItems = driver.findElements(HomePageLocators.bottomMenuItems);
        List<WebElement> menuItemsText = driver.findElements(HomePageLocators.bottomMenuItemsText);

        for (int i = 0; i < menuItemsText.size(); i++) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            String text = menuItemsText.get(i).getText();
            menuItems.get(i).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            logger.info("Clicked Menu Item - " + i + " " + text);
            WebElement value = driver.findElement(HomePageLocators.dynamicMenuItem(text));
            if (!value.isDisplayed()) {
                return false;
            }
            logger.info("Verified Item Details Matched - " + i + " " + text);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.navigate().back();
            logger.info("Back To Home - " + i + "\n");
        }

        return true;
    }
}
