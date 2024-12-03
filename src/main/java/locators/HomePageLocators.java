package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static By dynamicMenuItem(String menuName) {
        return By.xpath("//android.widget.TextView[@text='" + menuName + "']");
    }
    public static final By homeScreenText = By.xpath("//android.widget.TextView[@text=\"Products\"]\n");
    public static final By androidLogo = By.xpath("//android.view.ViewGroup[@content-desc=\"longpress reset app\"]/android.widget.ImageView");
    public static final By bottomMenuItems = By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])");
    public static final By bottomMenuItemsText = By.xpath("(//android.widget.TextView[@content-desc=\"store item text\"])");
}

