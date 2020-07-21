package connectViaWifi;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LearnLongPressAction {
	
	@Test
	public void learnLongPress() throws MalformedURLException, InterruptedException
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
		
		WebElement eleMessage = driver.findElementById("com.google.android.apps.messaging:id/conversation_name");
		
		TouchAction<?> action = new TouchAction(driver).
				longPress(LongPressOptions.longPressOptions()
							.withElement(ElementOption.element(eleMessage))
							.withDuration(Duration.ofSeconds(2))).perform();			
	}

}
