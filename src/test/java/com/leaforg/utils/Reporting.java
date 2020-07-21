package com.leaforg.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporting {
	
	public ExtentHtmlReporter html;
	public ExtentReports extent;
	public static ExtentTest suiteTest,test;
	
	public String testCaseName,testCaseDescription,testNodes,author,category;
	
	public String appPackage,appActivity,deviceName,udid,filename;
	
	public void startResult()
	{
		html = new ExtentHtmlReporter("./reports/result.html");
		html.config().setChartVisibilityOnOpen(true);
		html.config().setDocumentTitle("Appium Framework");
		html.setAppendExisting(true);
		
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	public void startTest(String testCaseName,String testCaseDescription)
	{
		suiteTest=extent.createTest(testCaseName,testCaseDescription);
		
	}
	
	public ExtentTest startNodes(String testNodes,String author,String category)
	{
		test=suiteTest.createNode(testNodes);
		test.assignAuthor(author);
		test.assignCategory(category);
		return test;
	}
	
	
	abstract public long takeSnapShot();
	
	
	public void reportStep(String desc,String status,boolean bSnap)
	{
		try
		{
			MediaEntityModelProvider img=null;
			long snapNumber;
			
			if(bSnap && !(status.equals("info")))
			{
				snapNumber = takeSnapShot();
				img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/"+snapNumber+".png").build();
			}
			
			if(status.equals("pass"))
			{
				test.pass(desc,img);
			}
			
			else if (status.equals("fail"))
			{
				test.fail(desc,img);
			}
			else if(status.equals("info"))
			{
				test.info(desc);
			}
		}
		
		catch(Exception e)
		{
			System.out.println("Issues in the reporting step>>" +e.getMessage());
		}
	}
	
	public void reportStep(String desc,String status)
	{
		reportStep(desc,status,true);
	}
	
	public void endResult()
	{
		extent.flush();
	}

}
