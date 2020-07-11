package learn.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Day4_InstallApp {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		//dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("deviceName", "Redmi Note 6 Pro");
		dc.setCapability("platformName", "Android");
		//dc.setCapability("platformVersion", "9.0");
		dc.setCapability("noReset", true);
		
		/*dc.setCapability("app", "D:\\Appium\\leaforg.apk");
		System.out.println("App is installed succesfully");*/
		
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		Thread.sleep(10000);
		driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("rajkumar@testleaf.com");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Leaf@123");
		driver.findElementByClassName("android.widget.Button").click();
		
		Thread.sleep(15000);
		String name="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]";
		WebElement participantName=driver.findElementByXPath(name);
		boolean verifyName=participantName.isDisplayed();
		
		if(verifyName)
		{
			System.out.println("User logged in successfully to the Leaf Org Application");
		}
		
		
	}

}
