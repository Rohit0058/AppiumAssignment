package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class PollingWait {

    private AppiumDriver driver;

    public PollingWait(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementWithPolling(By locator, int timeoutInSeconds, int pollingIntervalMs) {
        long endTime = System.currentTimeMillis() + Duration.ofSeconds(timeoutInSeconds).toMillis();

        while (System.currentTimeMillis() < endTime) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                }
            } catch (Exception ignored) {
                // Exception ignored since the element might not yet be present or visible
            }

            try {
                Thread.sleep(pollingIntervalMs); // Polling interval
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Polling wait interrupted", e);
            }
        }

        return null;
    }
}
