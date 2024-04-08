package pk_appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Drag_Drop_Example {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;

	@Test
	public void DragDrop() {

		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		MobileElement Firstele = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(0);
		MobileElement Secondele = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(3);

		TouchAction action = new TouchAction(driver);
		action.press(ElementOption.element(Firstele)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(ElementOption.element(Secondele)).release().perform();
	}

	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
		// Launch App
		File app = new File(".\\app\\DRAGDROP.apk");

		// Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("udid", "emulator-5554");
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
