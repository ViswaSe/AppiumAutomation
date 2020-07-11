package leaforg.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LearnMultiTouchActions {

	public static void main(String args[]) throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability("deviceName", "Andorid Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("noReset", true);

		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

		//Initialize the start & end X,Y values

		Dimension size = driver.manage().window().getSize();

		int width = size.getWidth(); int height = size.getHeight();

		int startX 	= (int) (width*0.5);
		int endX 	= startX;
		int startY	= (int) (height*0.2);
		int endY	= (int) (height*0.8);

		//code for Touch actions

		TouchAction<?> action1 = new TouchAction(driver)
				.press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(endX, endY))
				.release();

		TouchAction<?> action2 = new TouchAction(driver)
				.press(PointOption.point(endX, endY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(startX, startY))
				.release();

		//code to perform multi touch actions -> Right now it will not work as we are having the bug in appium version.

		new MultiTouchAction(driver).add(action1).add(action2).perform();

	}

}
