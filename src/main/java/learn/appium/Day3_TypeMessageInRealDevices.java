package learn.appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Day3_TypeMessageInRealDevices {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");
		dc.setCapability("deviceName", "Redmi Note 6 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
	
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
	
		System.out.println("App launched successfully");
		
		driver.findElementByAccessibilityId("Compose").click();
		Thread.sleep(5000);
		
		driver.findElementByAccessibilityId("Choose recipients").click();
		Thread.sleep(3000);
		
		driver.findElementById("android:id/input").click();
		driver.findElementById("android:id/input").sendKeys("Anirudh");
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/miui.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ListView/android.view.ViewGroup[1]/android.widget.CheckBox").click();
		Thread.sleep(2000);
		
		driver.findElementByAccessibilityId("OK").click();
		Thread.sleep(2000);
		
		driver.findElementById("com.android.mms:id/embedded_text_editor").sendKeys("This is an automated message triggered via appium server");
		driver.findElementByAccessibilityId("Send message").click();
		
		System.out.println("Message sent successfully");
	}

}
