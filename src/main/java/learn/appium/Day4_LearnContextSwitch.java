package learn.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Day4_LearnContextSwitch {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9.0");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		Set<String> contextHands=driver.getContextHandles();
		
		for(String eachContext:contextHands)
		{
			//System.out.println(eachContext);
			
			if(eachContext.contains("WEB"))
			{
				Thread.sleep(50000);
				driver.context(eachContext);
				System.out.println(eachContext);
			}
		}
		
	}

}
