package leaforg.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LearnStartActivity {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9.0");
		dc.setCapability("noReset", true);
		
/*		dc.setCapability("appPackage", "com.google.android.apps.messaging");
		dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");*/
		
		dc.setCapability("appPackage", "com.android.chrome");
		dc.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		Thread.sleep(3000);
		driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("www.google.com",Keys.ENTER);
		System.out.println("Chrome app launched succesfully");
		
		//Launching another application and switching to it - way 1 
		
		Activity act1 = new Activity("com.google.android.apps.messaging","com.google.android.apps.messaging.ui.ConversationListActivity");
		driver.startActivity(act1);
		/*Thread.sleep(5000);
		driver.findElementById("com.google.android.apps.messaging:id/conversation_name").click();
		Thread.sleep(3000);
		
		WebElement eleMessage = driver.findElementByAccessibilityId("You said, Hi Viswa, We welcome you , Sunday 10:48 PM, SMS");
		
		//Copy the message by using the long press touch actions
		
		TouchAction<?> action1=new TouchAction(driver)
								.longPress(LongPressOptions.longPressOptions()
											.withElement(ElementOption.element(eleMessage))
											.withDuration(Duration.ofSeconds(5)))
								.perform();
		
		String textMessage = eleMessage.getAttribute("content-desc");
		System.out.println(textMessage);*/
		
		//act1.setStopApp(true);
		
		//way 2 
		
		Activity act2 = new Activity("com.android.chrome","com.google.android.apps.chrome.Main");
		driver.startActivity(act2);
		
		System.out.println("switched back to chrome successfully");
		
	}

}
