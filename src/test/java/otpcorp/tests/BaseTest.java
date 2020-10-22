package otpcorp.tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import otpcorp.steps.OTPSteps;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {

    private static AndroidDriver driver;
    private static TouchAction touchAction;

    public OTPSteps otpSteps;

    public static AndroidDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.29.103:5555");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //platformName
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9"); //platformVersion
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        touchAction = new TouchAction(driver);
        otpSteps = new OTPSteps();
    }
}

