package otpcorp.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static otpcorp.tests.BaseTest.getDriver;

public abstract class BasePage {

    AndroidDriver driver;
    TouchAction touchAction;

    public BasePage() {
        this.driver = getDriver();

        touchAction = new TouchAction(driver);
    }

    public void swipe(int startY, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(0, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(0)))
                .moveTo(PointOption.point(0, endY))
                .release();

        touchAction.perform();
    }

    public WebElement defineElement(String idElement) {
        return driver.findElement(By.id(idElement));
    }

    public void touchElement(WebElement webElement) {
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(webElement)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .perform();
    }
}
