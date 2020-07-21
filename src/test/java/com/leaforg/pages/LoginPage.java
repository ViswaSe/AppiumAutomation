package com.leaforg.pages;

import com.leaforg.wrapper.AppSpecificMethods;

public class LoginPage extends AppSpecificMethods{
	
	public LoginPage enterEmailAddress(String username)
	{
		if(enterValue(username,"xpath","//input[@placeholder='Email']"))
		{
			reportStep("Email address " +username+" entered successfully","pass");
		}
		else
		{
			reportStep("Couldn't enter the email address","fail");
		}
		
		return this;
	}

	public LoginPage enterPassword(String password)
	{
		if(enterValue(password, "xpath", "//input[@placeholder='Password']"))
		{
			reportStep("Password "+password+" entered successfully","pass");
		}
		else
		{
			reportStep("couldn't enter the password","fail");
		}
		return this;
	}
	
	public HomePage clickLoginButton()
	{
		if(click("xpath", "//span[text()='Login']"))
		{
			reportStep("Login Button clicked successfully","pass");
		}
		else
		{
			reportStep("Couldn't click on the Login Button","fail");
		}
		
		return new HomePage();
	}
}
