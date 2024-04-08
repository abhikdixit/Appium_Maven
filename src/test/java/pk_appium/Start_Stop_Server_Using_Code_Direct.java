package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Start_Stop_Server_Using_Code_Direct {
	// public AndroidDriver driver;
	WebDriverWait wait;
	AppiumDriverLocalService service;
	AppiumDriver<MobileElement> driver;
	// Start_Appium_Server appiumServer;

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
		// Launch Device at run time
		// caps.setCapability("avd","Galaxy_Nexus_7");
		caps.setCapability("appPackage", "com.experitest.ExperiBank");
		caps.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");
		caps.setCapability("noReset", "false");

		// Calling the Start_Appium_Server Class

		/*
		 * appiumServer = new Start_Appium_Server(); appiumServer.startServer(); driver
		 * = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
		 * caps);
		 */
		// Below implementation to start Appium Desktop server at run time
		/*service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		// System.out.println("Server Started");
		driver = new AndroidDriver<MobileElement>(service.getUrl(), caps);
		// Its like Dynamic time to wait for Object Condition
		wait = new WebDriverWait(driver, 60);*/
		Start_Appium_Server appiumServer = new Start_Appium_Server();
		appiumServer.startServer();
		driver = new AndroidDriver<MobileElement>(service.getUrl(), caps);
	}

	@Test(priority = 1)
	public void EriBank_SignOn() {

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/usernameTextField")))
				.sendKeys("company");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/passwordTextField")))
				.sendKeys("company");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/loginButton")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/logoutButton")))
				.isDisplayed();

	}

	@Test(priority = 2)
	public void EriBank_MakePayment() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'Make Payment')]")))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/phoneTextField")))
				.sendKeys("123456789");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/nameTextField")))
				.sendKeys("Dixit");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/amountTextField")))
				.sendKeys("10");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/countryTextField")))
				.sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/countryButton")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'India')]"))).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/sendPaymentButton")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/logoutButton")))
				.click();

		String LoginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/loginButton")))
				.getText();
		Assert.assertEquals("Login", LoginButton);

	}

	@AfterTest
	public void teardown() {
		// driver.resetApp();
		driver.quit();
		service.stop();

		// appiumServer.stopServer();
	}
}
