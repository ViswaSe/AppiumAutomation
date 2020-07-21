package connectViaWifi;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LearnOrientationAndOpenNotifications {
	
	@Test
	public void verifyOrientation() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("udid", "emulator-5554");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.google.android.apps.messaging");
		dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		Thread.sleep(5000);
		
		//Open the notifications
		driver.openNotifications();
		
		//Get the screen orientation
		ScreenOrientation orientation = driver.getOrientation();
		System.out.println(orientation.toString());
	
		//Rotate the orientation to landscape
		Thread.sleep(5000);
		driver.rotate(ScreenOrientation.LANDSCAPE);
				
	}

}
