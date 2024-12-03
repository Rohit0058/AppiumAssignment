package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {

    private final AppiumDriver driver;

    public WaitUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForCondition(By locator, int timeoutInSeconds, int pollingIntervalMs, Function<WebElement, Boolean> condition) {
        FluentWait<AppiumDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingIntervalMs))
                .ignoring(Exception.class); // Ignore exceptions during polling

        return wait.until(d -> {
            WebElement element = driver.findElement(locator);
            if (condition.apply(element)) {
                return element;
            }
            return null;
        });
    }

    public WebElement waitForVisibility(By locator, int timeoutInSeconds, int pollingIntervalMs) {
        return waitForCondition(locator, timeoutInSeconds, pollingIntervalMs, WebElement::isDisplayed);
    }

    public WebElement waitForClickability(By locator, int timeoutInSeconds, int pollingIntervalMs) {
        return waitForCondition(locator, timeoutInSeconds, pollingIntervalMs, WebElement::isEnabled);
    }
}
