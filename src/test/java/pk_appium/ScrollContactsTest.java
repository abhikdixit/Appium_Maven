package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollContactsTest {

	public static AndroidDriver<MobileElement> driver;

	@Test
	public void ScrollTOoContact() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel_8");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "8.0");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator1");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
				"com.android.contacts.DialtactsContactsEntryActivity");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ScrollUtil.scrollToTextByAndroidUIAutomator("Amit Soni", driver).click();

		Thread.sleep(3000);

		driver.quit();
	}

}
