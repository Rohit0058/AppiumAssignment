package locators;

import org.openqa.selenium.By;

public class FormPageLocators {

    public static final By inputField = By.xpath("//android.widget.EditText[@content-desc=\"text-input\"]");
    public static final By youTypedField = By.id("input-text-result");
    public static final By dropdownField = By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]");
    public static final By selectFromDropdown = By.xpath("//android.widget.CheckedTextView[@text=\"This app is awesome\"]");
    public static final By switchField = By.xpath("//android.widget.Switch[@content-desc=\"switch\"]");
    public static final By inactiveButton = By.xpath("//android.view.ViewGroup[@content-desc=\"button-Inactive\"]");
    public static final By activeButton = By.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]");
}
