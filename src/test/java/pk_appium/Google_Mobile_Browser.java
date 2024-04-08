package pk_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventFlag;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_Mobile_Browser {

	
	public AndroidDriver<WebElement> driver;
	//public AndroidDriver driver;
    public WebDriverWait wait;
 
    @BeforeTest
    public void setup () throws MalformedURLException {
    
    	DesiredCapabilities  capabilities = new DesiredCapabilities();
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("deviceName", "Pixel");
        //Set UDID: Unique Device Identifier
    	capabilities.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("platformVersion", "7.0");
    	capabilities.setCapability("skipUnlock","true");
    	
    	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    	//Below Driver is for Chrome 69
    	
    	capabilities.setCapability("chromedriverExecutable","D:\\F Drive\\Appium Training\\workspace\\Appium_DemoProject\\chromedriver.exe");
    	//WebDriverManager.chromedriver().setup();
    	driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }
 
    @Test
    public void Login() throws InterruptedException {
    	driver.get("https://www.google.com");
    	System.out.println("Welcome to Google");
    	String GoogleTitle = driver.getTitle();
    	System.out.println(GoogleTitle);
    	driver.findElement(By.name("q")).sendKeys("Appium");
    	//driver.findElement(By.name("btnK")).click();

    }

 
/*    @Test
    public void basicTest () throws InterruptedException {
    	driver.get("https://www.google.com");
    	System.out.println("Welcome to Google");
    	String GoogleTitle = driver.getTitle();
    	System.out.println(GoogleTitle);

    }*/
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
