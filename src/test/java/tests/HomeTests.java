package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ConfigReader;

public class HomeTests extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void setupTest() throws Exception {
        setup(ConfigReader.get("platform"));
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomeScreen() {
        Assert.assertTrue(homePage.isHomeScreenDisplayed(), "Home screen text is not displayed!");
        Assert.assertTrue(homePage.isAndroidLogoDisplayed(), "Android logo is not displayed!");
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
