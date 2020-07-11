package newemulator;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class InstallApp {
	
	public static void main(String args[]) throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("deviceName", "Android Emulator");
		dc.setCapability("platformVersion", "10.0");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		
		//Installing leaf org in emulator
		dc.setCapability("app", "D:\\Appium\\leaforg.apk");
		
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		System.out.println("App installed succesfully as expected");
		
	}

}
