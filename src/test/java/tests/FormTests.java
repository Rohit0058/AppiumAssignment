package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.HomePage;
import pages.PopupPage;
import utils.ConfigReader;

public class FormTests extends BaseTest {
    FormPage formPage;
    PopupPage popupPage;
    HomePage homePage;

    @BeforeMethod
    public void setupTest() throws Exception {
        setup(ConfigReader.get("platform"));
        formPage = new FormPage(driver, waitUtils, logger);
        popupPage = new PopupPage(driver);
        homePage = new HomePage(driver, waitUtils, logger);
    }

    @Test
    public void testFormSubmissionAndPopUp() {
        homePage.isHomeScreenDisplayed();

        // Step 1: Taping Form Button
        homePage.tapFormButton();

        // Step 2: Fill all the form fields
        formPage.fillForm("Rohit", "This app is awesome", true);

        // Step 3: Validate Inactive Button is Disabled and Active Button is Enabled
        Assert.assertTrue(formPage.isInactiveButtonDisabled());
        Assert.assertTrue(formPage.isActiveButtonEnabled());

        // Step 4: Tap on the "Active" button
        popupPage = formPage.tapActiveButton();

        // Step 5: Validate the text on the pop-up
        String popUpText = popupPage.getPopUpText();
        Assert.assertEquals(popUpText, "This button is active");

        // Step 6: Tap on "Ask Me Later" from the pop-up
        popupPage.tapAskMeLater();

        // Step 7: Tap on "Home" from the bottom menu
        homePage.tapHomeButton();
    }
}
