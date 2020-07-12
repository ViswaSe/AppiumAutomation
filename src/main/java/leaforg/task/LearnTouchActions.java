package leaforg.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnTouchActions {

	public static void main(String args[]) throws MalformedURLException
	{

		//Install the multitouch tester in emulator

		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);

		//dc.setCapability("app", "D:\\Appium\\MultiTouch Tester_v1.2.apk");

		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Get the size of the window

		Dimension size	=driver.manage().window().getSize();
		int height		=size.getHeight();
		int width 		=size.getWidth();

		//Initialize the start & end X,Y values

		int startX 	= (int) (width*0.5);
		int endX 	= startX;
		int startY	= (int) (height*0.2);
		int endY	= (int) (height*0.8);

		int startCornerX	= (int) (width*0.8);
		int endCornerX 		= (int) (width*0.2);

		//code for Touch actions

		TouchAction<?> action = new TouchAction(driver)
				.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(endX, endY))
				.release().perform();

		TouchAction<?> action1 = new TouchAction(driver)
				.press(PointOption.point(endX, endY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(startX, startY))
				.release().perform();

		TouchAction<?> action2 = new TouchAction(driver)
				.press(PointOption.point(startCornerX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(endCornerX, endY))
				.release().perform();

		TouchAction<?> action3 = new TouchAction(driver)
				.press(PointOption.point(startCornerX, endY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(endCornerX, startY))
				.release().perform();

		System.out.println("Touch Action successfully done");
	}

}
