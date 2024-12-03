package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static By dynamicMenuItem(String menuName) {
        return By.xpath("//android.widget.TextView[@text='" + menuName + "']");
    }

    public static final By formButton = By.xpath("//android.view.View[@content-desc=\"Forms\"]");
    public static final By homeButton = By.xpath("//android.view.View[@content-desc=\"Home\"]");
    public static final By webViewButton = By.xpath("//android.view.View[@content-desc=\"Webview\"]");
    public static final By loginButton = By.xpath("//android.widget.TextView[@text=\"Login\"]");
    public static final By swipeButton = By.xpath("//android.view.View[@content-desc=\"Swipe\"]");
    public static final By dragButton = By.xpath("//android.widget.TextView[@text=\"Drag\"]");

    public static final By formScreen = By.xpath("//android.widget.ScrollView[@content-desc=\"Forms-screen\"]");
    public static final By webViewScreen = By.xpath("//android.webkit.WebView");
    public static final By loginScreen = By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]");
    public static final By swipeScreen = By.xpath("//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]");
    public static final By dragScreen = By.xpath("//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]");

    public static final By homeScreenText = By.xpath("//android.widget.TextView[@text=\"Demo app for the appium-boilerplate\"]");
    public static final By androidLogo = By.xpath("//android.widget.TextView[@text=\"\uDB80\uDC35\"]"); //By.xpath("//android.view.ViewGroup[@content-desc=\"longpress reset app\"]/android.widget.ImageView");
    public static final By bottomMenuItems = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[@content-desc]");
    public static final By bottomMenuItemsText = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[@content-desc]");

}

