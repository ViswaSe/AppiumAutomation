package leaforg.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

public class MobileWrapper {
	
	public static AppiumDriver<WebElement> driver;
	
	//Launch App in Mobile
	public boolean launchApp(String appPackage,String appActivity,String deviceName)
	{
		boolean bValue = false;
		try
		{
			DesiredCapabilities dc = new DesiredCapabilities();
			
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);
			dc.setCapability("deviceName", deviceName);
			dc.setCapability("platformName", "Android");
			dc.setCapability("noReset", true);
			
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
			
			bValue = true;
		} 
		
		catch (Exception e) {
			
			System.out.println("Issue in launching the app>>>>"+e.getMessage());
		}
		
		return bValue;
	}

	//Launch Browser
	public boolean launchBrowser(String browser,String deviceName,String url)
	{
		boolean bValue = false;
		try 
		{
			DesiredCapabilities dc = new DesiredCapabilities();
			
			dc.setCapability("browserName", browser);
			dc.setCapability("deviceName", deviceName);
			
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(5000);
			
			bValue = true;
		} 
		
		catch (Exception e) {
			System.out.println("Issue in launching the application via browser>>>>"+e.getMessage());
		}
		
		return bValue;
	}
	
	//switch from one application to another
	public void switchFromApplication(String appPackage,String appActivity)
	{
		((StartsActivity) driver).startActivity(new Activity(appPackage,appActivity));
	}
}

