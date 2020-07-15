package leaforg.framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleLaunch extends MobileWrapper {
	
	String appPackage,appActivity,deviceName;
	
	@BeforeTest
	public void provideData()
	{
		appPackage 	= "com.testleaf.leaforg";
		appActivity = "com.testleaf.leaforg.MainActivity";
		deviceName	= "Android";
		
	}
	
	@Test
	public void launchLeafOrgApplication()
	{
		launchApp(appPackage, appActivity, deviceName);
	}

}
