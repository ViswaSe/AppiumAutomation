package connectViaWifi;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LearnPointerInput {
	
	@Test
	public void learnPointerInput() throws MalformedURLException
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
		
		//Get the co-ordinates
		
		Dimension size = driver.manage().window().getSize();
		int height 	= size.getHeight();
		int width 	= size.getWidth();
		
		int valY1 	= (int) (height*0.5);
		int valY2	= (int) (height*0.1);
		int valY3 	= (int) (height*0.9);
		int valX1	= (int) (width*0.5);
		int valX2	= (int) (width*0.5);
		int valX3 	= (int) (width*0.9);
		int valX4	= (int) (width*0.1);
		
		PointerInput point1 = new PointerInput(PointerInput.Kind.TOUCH,"point1");
		Sequence seq1 = new Sequence(point1,1);
		seq1.addAction(point1.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), valX1, valY1));
		seq1.addAction(point1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq1.addAction(point1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), valX2, valY2));
		seq1.addAction(point1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		PointerInput point2 = new PointerInput(PointerInput.Kind.TOUCH,"point2");
		Sequence seq2 = new Sequence(point2,2);
		seq2.addAction(point2.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), valX1, valY1));
		seq2.addAction(point2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq2.addAction(point2.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), valX2, valY3));
		seq2.addAction(point2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		PointerInput point3 = new PointerInput(PointerInput.Kind.TOUCH,"point3");
		Sequence seq3 = new Sequence(point3,3);
		seq3.addAction(point3.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), valX1, valY1));
		seq3.addAction(point3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq3.addAction(point3.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), valX3,valY1));
		seq3.addAction(point3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		PointerInput point4 = new PointerInput(PointerInput.Kind.TOUCH,"point4");
		Sequence seq4 = new Sequence(point4,4);
		seq4.addAction(point4.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), valX1, valY1));
		seq4.addAction(point4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq4.addAction(point4.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), valX4, valY1));
		seq4.addAction(point4.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq1,seq2,seq3,seq4));
	}

}
