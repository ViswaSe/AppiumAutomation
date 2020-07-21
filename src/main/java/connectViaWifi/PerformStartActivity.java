package connectViaWifi;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class PerformStartActivity {

	@Test
	public void startAnotherApp() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("udid", "emulator-5554");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		Thread.sleep(5000);
		
		String appPackage  = "com.google.android.apps.messaging";
		String appActivity = "com.google.android.apps.messaging.ui.ConversationListActivity";
		
		Activity act = new Activity(appPackage,appActivity);
		driver.startActivity(act);
		act.setStopApp(true);
		
	}

}
