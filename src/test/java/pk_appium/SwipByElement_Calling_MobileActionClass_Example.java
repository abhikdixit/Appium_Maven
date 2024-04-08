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

public class SwipByElement_Calling_MobileActionClass_Example {
	public static AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	MobileActions action;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nexus_7");
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
	public void SwipByElement() throws InterruptedException {

		System.out.println("Welcome to Android Settings for SwipByElement functionality");
		Thread.sleep(2000);
		WebElement GetDisplay = wait	
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Display')]")));

		WebElement GetAccounts = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Printing')]")));

		action = new MobileActions(driver);
		action.swipeByElements(GetDisplay, GetAccounts);
		Thread.sleep(3000);
	}

	@AfterTest
	public void Quit() {
		// driver.resetApp();
		driver.quit();
	}
}
