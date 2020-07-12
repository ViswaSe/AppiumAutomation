package leaforg.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TouchActionLongPress {

	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("noReset", true);
		
		dc.setCapability("appPackage", "com.google.android.apps.messaging");
		dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		Thread.sleep(10000);
		
		driver.findElementById("com.google.android.apps.messaging:id/conversation_name").click();
		Thread.sleep(3000);
		
		WebElement eleMessage=driver.findElementById("com.google.android.apps.messaging:id/message_text_and_info");
			
		//Performing Long press in the message application
		
		TouchAction<?> action = new TouchAction(driver)
								.longPress(LongPressOptions.longPressOptions()
											.withElement(ElementOption.element(eleMessage))
											.withDuration(Duration.ofSeconds(3)))
								.perform();
		
		Thread.sleep(2000);	
		driver.findElementByAccessibilityId("Copy text").click();
		
		System.out.println("Long press performed successfully done");
		
	}
}
