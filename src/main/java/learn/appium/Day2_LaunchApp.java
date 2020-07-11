package learn.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Day2_LaunchApp {
	
	public static void main(String args[]) throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 6 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		
		/*dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");*/
		
		dc.setCapability("appPackage", "com.android.contacts");
		dc.setCapability("appActivity", "com.android.contacts.activities.TwelveKeyDialer");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
		System.out.println("Given app launched succesfully");
	}

}
