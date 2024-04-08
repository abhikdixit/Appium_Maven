package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OTP_Verification {
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	
  @Test
  public void EriBank_SignOn() {
	  //OTP_Verification obj = new OTP_Verification();
	  //obj.verifyOTPValue();
	  verifyOTPValue();
  }
  
  public void verifyOTPValue()
	{
		//driver.findElementByAccessibilityId("OS").click();
		//driver.findElementByAccessibilityId("SMS Messaging").click();
	  	driver.findElement(By.id("com.google.android.apps.messaging:id/start_new_conversation_button")).click();
		driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view").sendKeys("04456");
		driver.findElementByXPath("//*[contains(@text,'FREQUENTS')]").click();
		driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("DEMO OTP: 6549");
		driver.findElementByAccessibilityId("Send Message").click();
		String otpValue = getOTP();
		System.out.println("OTP VALUE : "+otpValue);
	}
	
	
	public String getOTP()
	{
		//driver.startActivity("com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
		String getOTPValue = driver.findElementById("com.google.android.apps.messaging:id/message_text").getText().split(":")[1].trim();
		return getOTPValue;
	}
  
  @BeforeTest
  public void LaunchApp() throws MalformedURLException {
	  
	  	DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel");
		caps.setCapability("udid", "emulator-5554");
		//caps.setCapability("udid", "07c261d7028a5114"); //DeviceId from "adb devices" command
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("skipUnlock","true");
		//Launch Device at run time
		//caps.setCapability("avd","Galaxy_Nexus_7");
		caps.setCapability("app", System.getProperty("user.dir")+"//app//Api_Demo.apk");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity","com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
		caps.setCapability("noReset","false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);

		wait = new WebDriverWait(driver, 60);
	  
  }

  @AfterTest
  public void CloseApp() {
	  driver.quit();
	  
  }

}
