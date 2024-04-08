package pk_appium;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Eribank_Parallel_Execution {
	public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
 
    @Parameters({ "deviceName_","UDID_","platformVersion_", "URL_" })
    @BeforeTest
    public void setup (String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability("deviceName", deviceName_);
       //Set UDID: Unique Device Identifier
       caps.setCapability("udid", UDID_); //DeviceId from "adb devices" command
       caps.setCapability("platformName", "Android");
       caps.setCapability("platformVersion", platformVersion_);
       caps.setCapability("skipUnlock","true");
		caps.setCapability("appPackage", "com.experitest.ExperiBank");
		caps.setCapability("appActivity","com.experitest.ExperiBank.LoginActivity");
       caps.setCapability("noReset","false");
       //driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
       driver = new AndroidDriver<MobileElement>(new URL("http://"+URL_),caps);
       wait = new WebDriverWait(driver, 10);
    }
  
    @Test(priority=1)
    public void EriBank_SignOn() {
  	  
  	  wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/usernameTextField"))).sendKeys("company");

  		wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/passwordTextField"))).sendKeys("company");

  		wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/loginButton"))).click();
  		
  		
  		wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/logoutButton"))).isDisplayed();
  	  
    }
    
    @Test(priority=2)
    public void EriBank_MakePayment() {
    	String am = "20";
    	String initBal = wait.until(ExpectedConditions.visibilityOfElementLocated
  			  (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View")))
  			  .getText();
  	  
  	  
  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'Make Payment')]")))
  		.click();

  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/phoneTextField")))
  		.sendKeys("9999999999");
  		
  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/nameTextField")))
  		.sendKeys("Kaushik");
  		
  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/amountTextField"))).sendKeys(am);

  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/countryTextField")))
  		.sendKeys("India");

  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/countryButton")))
  		.click();

  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text, 'India')]"))).click();
  		
  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.experitest.ExperiBank:id/sendPaymentButton")))
  		.click();
  	  
  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1"))).click();
  		
  	  String reqResult = wait.until(ExpectedConditions.visibilityOfElementLocated
  			  (By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View")))
  			  .getText();
  	  
  	  System.out.println("Required result: " + reqResult);
  	  int bal = Integer.parseInt(initBal.substring(17, 20)) - Integer.parseInt(am);
  	  String res = String.valueOf(bal) + ".00$";
  	  System.out.println("Your result: " + res);
  	  
  	  Assert.assertEquals("Your balance is: " + res, reqResult);
  	  
  		
    }
    
 
    @AfterTest
    public void teardown(){
    //	driver.resetApp();
    	wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/logoutButton"))).click();
  		
  	  String LoginButton=wait.until(ExpectedConditions.visibilityOfElementLocated
  				(By.id("com.experitest.ExperiBank:id/loginButton"))).getText();
  	  Assert.assertEquals("Login", LoginButton);
    	driver.quit();
    }

}
