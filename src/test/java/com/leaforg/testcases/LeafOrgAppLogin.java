package com.leaforg.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaforg.pages.LoginPage;
import com.leaforg.wrapper.AppSpecificMethods;

public class LeafOrgAppLogin extends AppSpecificMethods{
	
	@BeforeTest
	public void provideData()
	{
		testCaseName 		= "Leaf Org Login";
		testCaseDescription = "Login into the LeafOrg Application";
		testNodes			= "TC001";
		appPackage 			= "com.testleaf.leaforg";
		appActivity			= "com.testleaf.leaforg.MainActivity";
		deviceName			= "Android Emulator";
		udid				= "emulator-5554";
		filename			= "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public void loginIntoLeafOrg(String username,String password,String partName)
	{
		new LoginPage()
		.enterEmailAddress(username)
		.enterPassword(password)
		.clickLoginButton()
		.verifyParticipantName(partName);
	}

}
