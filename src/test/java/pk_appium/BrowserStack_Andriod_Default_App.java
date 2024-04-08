package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

// Below code for Real Device

public class BrowserStack_Andriod_Default_App {


	public AndroidDriver<AndroidElement> driver;
	public WebDriverWait wait;

	@BeforeTest
	public void setup () throws MalformedURLException {
		
	      DesiredCapabilities caps = new DesiredCapabilities();
	      
	   // Set your access credentials
	      caps.setCapability("browserstack.user", "abhidixit1");
	      caps.setCapability("browserstack.key", "qykJFYSkKCorcy52a6X1");
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "Google Pixel 3");
	      caps.setCapability("os_version", "9.0");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "First Java Project");
	      caps.setCapability("build", "Java Android");
	      caps.setCapability("name", "first_test");
	        
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        driver = new AndroidDriver<AndroidElement>(
	            new URL("http://hub.browserstack.com/wd/hub"), caps);

		wait = new WebDriverWait(driver, 30);
	}


	@Test
	public void Wikipedia() throws InterruptedException {

		AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
	            ExpectedConditions.elementToBeClickable(
	                MobileBy.AccessibilityId("Search Wikipedia")));
	        searchElement.click();
	        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
	              ExpectedConditions.elementToBeClickable(
	                  MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
	        insertTextElement.sendKeys("BrowserStack");
	        Thread.sleep(5000);
	        List<AndroidElement> allProductsName = driver.findElementsByClassName(
	            "android.widget.TextView");
	        assert(allProductsName.size() > 0);
	}
	  
	  @AfterTest
	  public void CloseApp() {
		  driver.quit();
		  
	  }
}
