package leaforg.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LearnPointerInput {

	public static void main(String args[]) throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("noReset", true);

		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");

		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Get the co-ordinates 
		
		Dimension size = driver.manage().window().getSize();
		
		int startX	= (int) (size.getWidth() * 0.2);
		int endX 	= (int) (size.getWidth() * 0.8);
		int Y	 	= (int) (size.getHeight()*0.5);

		//Action1 using Pointer Input

		PointerInput point1 = new PointerInput(PointerInput.Kind.TOUCH,"point1");
		Sequence seq1 = new Sequence(point1,1);
		
		//Press and start moving towards the direction from start X
		seq1.addAction(point1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, Y));
		seq1.addAction(point1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		//Move towards the direction to end X and release
		seq1.addAction(point1.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), endX, Y));
		seq1.addAction(point1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	
		//Action2 using pointer Input
		PointerInput point2 = new PointerInput(PointerInput.Kind.TOUCH,"point2");
		Sequence seq2 = new Sequence(point2,2);
		
		//Press and move from end X
		seq2.addAction(point2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), endX, Y));
		seq2.addAction(point2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		
		//Move to start X and release
		seq2.addAction(point2.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(), startX, Y));
		seq2.addAction(point2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Arrays.asList(seq1,seq2));
		
		System.out.println("Multi action performed successfully");
		
	}

}
