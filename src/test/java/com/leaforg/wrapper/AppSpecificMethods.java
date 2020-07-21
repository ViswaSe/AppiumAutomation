package com.leaforg.wrapper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.leaforg.utils.DataInputProvider;

public class AppSpecificMethods extends MobileWrapper {
	
	@BeforeSuite
	public void beforeSuite()
	{
		startResult();
	}
	
	@BeforeClass
	public void beforeClass()
	{
		startTest(testCaseName,testCaseDescription);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		startNodes(testNodes, author, category);
		launchApp(appPackage, appActivity, deviceName, udid);
		switchWebview();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] readDataFromExcel()
	{
		return new DataInputProvider().readValuesFromExcel("./data/"+filename+".xlsx");
	}

	@AfterMethod
	public void afterIteration()
	{
		endResult();
	}
	
}
