package connectViaWifi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;

public class GetBatteryInfo {
	
	@Test
	public void learnBatteryInfo() throws MalformedURLException, InterruptedException
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
		
/*		//Way1:-
		AndroidBatteryInfo battery = driver.getBatteryInfo();
		System.out.println(battery.getState());
		System.out.println(battery.getLevel());*/
		
		//Way2:-
		Map<String,String> map = new HashMap<String,String>();
		map.put("command", "dumpsys");
		map.put("args", "battery");
		
		Object executeScript = driver.executeScript("mobile:shell", map);
		System.out.println(executeScript.toString());
	}

}
