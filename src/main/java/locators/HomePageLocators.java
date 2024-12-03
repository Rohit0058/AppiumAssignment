package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static By dynamicMenuItem(String menuName) {
        return By.xpath("//android.widget.TextView[@text='" + menuName + "']");
    }
    public static final By formButton = By.xpath("//android.widget.TextView[@text=\"Forms\"]");
    public static final By homeButton = By.xpath("//android.widget.TextView[@text=\"Home\"]");
    public static final By webViewButton = By.xpath("//android.widget.TextView[@text=\"Webview\"]");
    public static final By loginButton = By.xpath("//android.widget.TextView[@text=\"Login\"]");
    public static final By swipeButton = By.xpath("//android.widget.TextView[@text=\"Swipe\"]");
    public static final By dragButton = By.xpath("//android.widget.TextView[@text=\"Drag\"]");

    public static final By homeScreenText = By.xpath("//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]");
    public static final By androidLogo = By.xpath("//android.widget.TextView[@text=\"\uDB80\uDC35\"]"); //By.xpath("//android.view.ViewGroup[@content-desc=\"longpress reset app\"]/android.widget.ImageView");
    public static final By bottomMenuItems = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[@content-desc]");
    public static final By bottomMenuItemsText = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[@content-desc]");

}

