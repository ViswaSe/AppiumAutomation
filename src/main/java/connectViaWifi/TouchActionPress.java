package connectViaWifi;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TouchActionPress {
	
	@Test
	public void touchActionPress() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Redmi Note 6 Pro");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9.0");
		dc.setCapability("udid", "192.168.1.101:5555");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		Thread.sleep(10000);
		
		//Scrolling up to down
		Dimension size = driver.manage().window().getSize();
		int height  = size.getHeight();
		int width 	= size.getWidth();
		
		int startX 	= (int) (width*0.5);
		int endX  	= startX;
		int startX1 = (int) (width*0.2);
		int endX1	= (int) (width*0.9);
		int startY	= (int) (height*0.2);
		int endY	= (int) (height*0.8);
		int startY1 = (int) (height*0.9);
		int endY1	= (int) (height*0.1);
		int baseY 	= (int) (height*0.5);
		
		TouchAction<?> action1  = new TouchAction(driver)
								.press(PointOption.point(startX, startY))
								.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
								.moveTo(PointOption.point(endX, endY))
								.release().perform();
		
		//Scrolling down to up
		TouchAction action2 = new TouchAction(driver)
								.press(PointOption.point(startX, startY1))
								.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
								.moveTo(PointOption.point(endX,endY1)).release().perform();
		
		//scrolling left to right
		TouchAction<?> action3 = new TouchAction(driver).press(PointOption.point(startX1, baseY))
									.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
									.moveTo(PointOption.point(endX1, baseY)).release().perform();
	
	
		//scrolling from right to left
		TouchAction<?> action4 = new TouchAction(driver).press(PointOption.point(endX1, baseY))
									.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
									.moveTo(PointOption.point(startX1, baseY)).release().perform();
		
	}
	

}
