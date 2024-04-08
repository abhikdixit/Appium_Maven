package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollDown_Using_X_Y_Cordinate_Example {
	public static AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	MobileActions action;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		// Set UDID: Unique Device Identifier
		caps.setCapability("udid", "emulator-5554"); // DeviceId from "adb
														// devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("skipUnlock", "true");
		caps.setCapability("appPackage", "com.android.settings");
		caps.setCapability("appActivity", "com.android.settings.Settings");
		caps.setCapability("noReset", "false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void SwipByPercentage() throws InterruptedException {

		System.out.println("Welcome to Android Settings for Tap functionality");
		Thread.sleep(2000);
		// The viewing size of the device
		/*
		 * Dimension size = driver.manage().window().getSize();
		 * 
		 * //x position set to mid-screen horizontally int width = size.width /
		 * 2;
		 * 
		 * //Starting y location set to 80% of the height (near bottom) int
		 * startPoint = (int) (size.getHeight() * 0.80);
		 * 
		 * //Ending y location set to 20% of the height (near top) int endPoint
		 * = (int) (size.getHeight() * 0.20);
		 * 
		 * new TouchAction(driver).press(PointOption.point(width,
		 * startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(
		 * 2000))).moveTo(PointOption.point(width,
		 * endPoint)).release().perform();
		 */
		action = new MobileActions(driver);
		action.verticalSwipeByPercentages(0.80, 0.20, 0.5);
		Thread.sleep(3000);
	}


	@AfterTest
	public void Quit() {
		// driver.resetApp();
		driver.quit();
	}
}
