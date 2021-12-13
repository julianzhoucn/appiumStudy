package com.liangz;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
    public AppiumDriver<WebElement> driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "yourDeviceName");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "yourDeviceId");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 90);  //If no command input, then will delete the session.
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            desiredCapabilities.setCapability("chromedriverExecutableDir", "c:/chromedriver");
            desiredCapabilities.setCapability("recreateChromeDriverSessions", true);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");


            URL url = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AppiumDriver<>(url, desiredCapabilities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {

    }
}
