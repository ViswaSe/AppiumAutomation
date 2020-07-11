package leaforg.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	public static AndroidDriver<WebElement> driver;

	public void preLogin() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("noReset", true);
		
	//Launch the leaforg app
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		
	//Android Driver launch
		driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	//switching to web context of leaftaps application
		
		switchToWebContext();
		
	}
	
	public void login(String username,String password) throws InterruptedException
	{
		
	//Enter Credentials And Perform Login	
		driver.findElementByXPath("//input[@placeholder='Email']").sendKeys(username);
		driver.findElementByXPath("//input[@placeholder='Password']").sendKeys(password);
		driver.findElementByXPath("//span[text()='Login']").click();
		Thread.sleep(10000);
		
	}

	public void switchToWebContext()
	{
		Set<String> allContext=driver.getContextHandles();
		
		for(String each:allContext)
		{
			System.out.println(each);
				if(each.contains("WEB"))
					driver.context(each);
		}
	}
	
	public void threadWait() throws InterruptedException 
	{
		Thread.sleep(5000);
	}
	
	public void afterLogin()
	{
		boolean dis=driver.findElementByXPath("//label[contains(text(),'Babu')]").isDisplayed();
		if(dis)
		{
			System.out.println("Login to the Leaf org application successfully done.");
		}
	}
	
	public void logout() throws InterruptedException
	{
		driver.findElementByXPath("//span[text()='LOGOUT']").click();
		threadWait();
		driver.findElementByXPath("//span[contains(text(),'Yes, logout')]").click();
		threadWait();
		System.out.println("User logged out successfully");
	}
}
