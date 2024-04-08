package pk_appium;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;


public class WindowsOS_App_Alarm {
	public static WindowsDriver driver=null;

    @BeforeTest
    public void setUp() throws IOException {
    	
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Windows");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("deviceName", "WindowsPC");
        caps.setCapability("app", "C:\\Users\\adixit\\AppData\\Roaming\\Zoom\\bin\\Zoom.exe");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"),caps);
        driver.manage().window().maximize();
    }

   @AfterTest
    public void tearDown() {
          //  driver.quit();
    }

    @Test
    public void testWeatherApp() throws InterruptedException {
    	
    	driver.findElementByName("Sign In").click();
    	Thread.sleep(5000);
    	driver.findElementByName("Please enter your Meeting ID or Personal Link Name").sendKeys("444444444");
    	driver.findElementByName("Please enter your name").sendKeys("Dixit");
    	driver.findElementByName("Join").click();
}
}
