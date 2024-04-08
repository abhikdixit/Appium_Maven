package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.TouchAction;


public class SwipTouch_Using_Cordinate_Simulator {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	MobileActions action;
 
    @BeforeTest
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability("deviceName", "Galaxy_Nexus_7");
       //Set UDID: Unique Device Identifier
       caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
       caps.setCapability("platformName", "Android");
       caps.setCapability("platformVersion", "7.0");
       caps.setCapability("skipUnlock","true");
       caps.setCapability(MobileCapabilityType.APP, "D:\\F Drive\\Appium Training\\SwipeListView.apk");
       /*caps.setCapability("appPackage", "com.intelloware.apkinfo");
       caps.setCapability("appActivity","com.intelloware.apkinfo.MainActivity");*/
       caps.setCapability("noReset","false");
       driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
       wait = new WebDriverWait(driver, 10);
    }
  
    @Test
    public void Swipe_Test () throws InterruptedException {
 
    	System.out.println("Welcome to APK Info APP for Long Press functionality");
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1"))).click();

        // Get the size of screen.
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        // Find swipe x points from screen's with and height.
        // Find x1 point which is at right side of screen.
        int x1 = (int) (size.width * 0.20);
        // Find x2 point which is at left side of screen.
        int x2 = (int) (size.width * 0.80);

        // Create object of TouchAction class.
        TouchAction action = new TouchAction(driver);

        // Find element to swipe from right to left.
        WebElement ele1 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/front")
                .get(3);
        // Create swipe action chain and perform horizontal(right to left) swipe.
        // Here swipe to point x1 Is at left side of screen. So It will swipe element
        // from right to left.
        action.longPress(ElementOption.element(ele1)).moveTo(ElementOption.element(ele1, x1, 580)).release().perform();

        Thread.sleep(5000);

        // Find element to swipe from left to right.
        WebElement ele2 = (WebElement) driver.findElementsById("com.fortysevendeg.android.swipelistview:id/back")
                .get(4);
        // Create swipe action chain and perform horizontal(left to right) swipe.
        // Here swipe to point x2 Is at right side of screen. So It will swipe element
        // from left to right.
        action.longPress(ElementOption.element(ele2)).moveTo(ElementOption.element(ele2, x2, 580)).release().perform();

        Thread.sleep(9500);
    }
 
    @AfterTest
    public void Quit(){
    //	driver.resetApp();
        driver.quit();
    }
}
