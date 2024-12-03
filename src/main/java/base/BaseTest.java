package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.ios.IOSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigReader;
import utils.LoggerUtils;
import utils.WaitUtils;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected Logger logger = LoggerUtils.getLogger(this.getClass());
    protected AppiumDriver driver;
    protected WaitUtils waitUtils;

    public void setup(String platform) throws Exception {
        logger.info("Setting up the Appium driver and test environment");
        if (platform.equalsIgnoreCase("android")) {
            driver = new AppiumDriver(new URL(ConfigReader.get("serverUrl")), getAndroidCapabilities());
        } else if (platform.equalsIgnoreCase("ios")) {
            driver = new IOSDriver(new URL(ConfigReader.get("serverUrl")), getIOSCapabilities());
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
        waitUtils = new WaitUtils(driver);
    }

    private UiAutomator2Options getAndroidCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName(ConfigReader.get("deviceName"));
        options.setApp(ConfigReader.get("appPath"));
        options.setAutomationName("UiAutomator2");
        return options;
    }

    private XCUITestOptions getIOSCapabilities() {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("iOS");
        options.setDeviceName(ConfigReader.get("iosDeviceName"));
        options.setApp(ConfigReader.get("iosAppPath"));
        options.setAutomationName("XCUITest");
        return options;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Appium session ended");
        }
    }
}
