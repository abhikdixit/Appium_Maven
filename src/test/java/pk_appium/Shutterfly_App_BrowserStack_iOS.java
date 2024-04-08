package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

// Below code for Real Device

public class Shutterfly_App_BrowserStack_iOS {

	public AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		// Set your access credentials

		caps.setCapability("browserstack.user", "abhidixit1");

		caps.setCapability("browserstack.key", "qykJFYSkKCorcy52a6X1");

		// Set URL of the application under test

		//caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

		// Specify device and os_version for testing

		caps.setCapability("device", "iPhone 15");

		caps.setCapability("os_version", "11.0");

		// Set other BrowserStack capabilities

		caps.setCapability("project", "Google WebSite");

		caps.setCapability("build", "browserstack-build-1");

		caps.setCapability("name", "BrowserStak_test");

		// Initialize the remote Webdriver using BrowserStack remote URL

		// and desired capabilities defined above

		driver = new AndroidDriver<AndroidElement>(

				new URL("http://hub.browserstack.com/wd/hub"), caps);

	}


	@Test
	public void basicTest () throws InterruptedException {

		driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
}
}
	
