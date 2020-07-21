package connectViaWifi;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;

public class WifiDisabled {
	
	@Test
	public void learnWifiEnabled_Disabled() throws MalformedURLException, InterruptedException
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
		
		driver.openNotifications();
		
		ConnectionStateBuilder csb = new ConnectionStateBuilder();
		ConnectionState state = csb.withWiFiDisabled().build();
		driver.setConnection(state);
		
		Thread.sleep(5000);
		ConnectionState state1=csb.withWiFiEnabled().build();
		driver.setConnection(state1);
	}

}
