package pk_appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestScrollUpandDown {

	public static AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	@Test
	public void ScrollUpDown() throws MalformedURLException, InterruptedException {

		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		Thread.sleep(2000);

		ScrollUtil.scrollUp(2, driver);

		Thread.sleep(2000);

		ScrollUtil.scrollDown(1, driver);

		Thread.sleep(5000);

	}

	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
		// Launch App
		File app = new File(".\\app\\DRAGDROP.apk");

		// Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		wait = new WebDriverWait(driver, 60);

	}

	@AfterTest
	public void CloseApp() {
		driver.quit();

	}
}
