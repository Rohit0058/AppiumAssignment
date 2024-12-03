package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;
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
                .ignoring(NoSuchElementException.class) // Ignore element not found
                .ignoring(StaleElementReferenceException.class); // Handle stale elements during polling

        try {
            return wait.until(driver -> {
                WebElement element = driver.findElement(locator);
                return condition.apply(element) ? element : null;
            });
        } catch (TimeoutException e) {
            throw new TimeoutException("Condition not met for element located by: " + locator + " within " + timeoutInSeconds + " seconds.", e);
        }
    }

    public WebElement waitForVisibility(By locator, int timeoutInSeconds, int pollingIntervalMs) {
        return waitForCondition(locator, timeoutInSeconds, pollingIntervalMs, WebElement::isDisplayed);
    }

    public WebElement waitForClickability(By locator, int timeoutInSeconds, int pollingIntervalMs) {
        return waitForCondition(locator, timeoutInSeconds, pollingIntervalMs, element -> element.isDisplayed() && element.isEnabled());
    }
}
