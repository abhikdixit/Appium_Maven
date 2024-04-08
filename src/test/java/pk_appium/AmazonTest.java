package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class AmazonTest {
	public static AndroidDriver<WebElement> driver;

	@Test
	public void SearchProduct() throws MalformedURLException, InterruptedException {

		//Package and Activity information

	//	adb shell
	//	dumpsys window windows | grep -E 'mCurrentFocus'
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");

		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.amazon.mShop.android.shopping");

		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.mShop.home.HomeActivity");
		
		
		
	
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.Button[3]")).click();
		
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("shoes");
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		Thread.sleep(5000);
		
		
		
		ScrollUtil.scrollToElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewAnimator/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View/android.view.View[25]\r\n" + 
				""), driver).click();
		
		Thread.sleep(10000);

		
		
	

		driver.quit();
	}
	
	
	
	
	
	
	
	public static AndroidElement ScrollToElement(By by, int miliseconds) {
		AndroidElement element = null;
		int numberOfTimes = 10;
		Dimension size = driver.manage().window().getSize();
		int anchor = (int)(size.width / 2);
		//Swipe up to scroll down
		int startPoint = (int)(size.height - 10);
		int endPoint = 10;

		for (int i = 0; i < numberOfTimes; i++) {
		try {
		new TouchAction(driver)
		.longPress(PointOption.point(anchor, startPoint)) //.press(point(anchor, startPoint)) if used press need proper waiting time
		//.waitAction(waitOptions(ofMillis(miliseconds)))
		.moveTo(PointOption.point(anchor, endPoint)).release().perform();
		element = (AndroidElement) driver.findElement(by);
		i = numberOfTimes;
		} catch (NoSuchElementException ex) {
		System.out.println(String.format("Element not available. Scrolling (%s) times�", i + 1));
		}
		}
		return element;
		}

}
