package newemulator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LaunchLeafOrg {
	
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		//Wait time for loading
		Thread.sleep(10000);
		
		//To get the context details & switched to web mode successfully
		Set<String> contextDetails=driver.getContextHandles();
		for(String eachContext:contextDetails)
		{
			System.out.println(eachContext);
			driver.context(eachContext);
		}
		
		//Login into leaf org application
		System.out.println(driver.getTitle());
		driver.findElementByXPath("//input[@placeholder='Email']").sendKeys("rajkumar@testleaf.com");
		driver.findElementByXPath("//input[@placeholder='Password']").sendKeys("Leaf@123");
		driver.findElementByXPath("//span[text()='Login']").click();
		Thread.sleep(10000);
		
		//Validation after login
		boolean participantName=driver.findElementByXPath("//label[text()='Babu Manickam']").isDisplayed();	
		System.out.println("You can see the label after login: "+participantName);
		
		
	
	}

}
