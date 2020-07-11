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

public class LearnZoomIn {
	
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
		
		//Gathering co.ordinates 
		
		Dimension size = driver.manage().window().getSize();
		
		int baseX	= (int) (size.getWidth() * 0.5);
		int topX	= (int) (size.getWidth() * 0.2);
		int baseY	= (int) (size.getHeight() * 0.5);
		int topY 	= (int) (size.getHeight() * 0.2);
		int bottomX	= (int) (size.getWidth() * 0.8);
		int bottomY	= (int) (size.getHeight() * 0.8);
		
		//Perform Action1 
		
		PointerInput action1 = new PointerInput(PointerInput.Kind.TOUCH,"action1");
		Sequence seq1 = new Sequence(action1,1);
		
		//Move towards top corner from the middle of the screen - Zooming In
		seq1.addAction(action1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), baseX, baseY));
		seq1.addAction(action1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq1.addAction(action1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), topX, topY));
		seq1.addAction(action1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//Perform Action2 
		
		PointerInput action2 = new PointerInput(PointerInput.Kind.TOUCH,"action2");
		Sequence seq2 = new Sequence(action2,2);
		
		//Move towards down corner from the middle of the screen - Zooming In
		seq2.addAction(action2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), baseX, baseY));
		seq2.addAction(action2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq2.addAction(action2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), bottomX, bottomY));
		seq2.addAction(action2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//Perform Action3 
		PointerInput action3 = new PointerInput(PointerInput.Kind.TOUCH,"action3");
		Sequence seq3 = new Sequence(action3,3);
		
		//Move from left to right to zoom in the left corner place 
		seq3.addAction(action3.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), topX, topY));
		seq3.addAction(action3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		seq3.addAction(action3.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),bottomX,topY));
		seq3.addAction(action3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		//Perform Actions simultaneously
		driver.perform(Arrays.asList(seq1,seq2));
		driver.perform(Arrays.asList(seq3));
		
	}

}
