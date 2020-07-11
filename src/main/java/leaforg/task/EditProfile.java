package leaforg.task;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class EditProfile extends BaseClass {
	
	public static void main(String args[]) throws InterruptedException, MalformedURLException
	{
		String username="rajkumar@testleaf.com";
		String password="Leaf@123";
	
	//perform login 
		BaseClass obj = new BaseClass();
		obj.preLogin();
		obj.login(username, password);
		obj.afterLogin();
		
	//click on settings icon
		WebElement eleSettings=driver.findElementByXPath("//ion-icon[@aria-label='settings']");
		eleSettings.click();
		obj.threadWait();
		
	//click on My Profile
		driver.findElementByXPath("(//ion-icon[@aria-label='arrow forward'])[1]").click();
		obj.threadWait();
		
	//Change the first name and last name of the user
		
		String firstName="Babu"; String lastName="Manickam";
		
		WebElement eleFirstName=driver.findElementByXPath("//input[@placeholder='First Name']");
		eleFirstName.clear();
		eleFirstName.sendKeys(firstName);
		
		WebElement eleLastName=driver.findElementByXPath("//input[@placeholder='Last Name']");
		eleLastName.clear();
		eleLastName.sendKeys(lastName);
	
	//click on save changes button
		
		WebElement eleSaveChangesBtn=driver.findElementByXPath("//span[text()='SAVE CHANGES']");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",eleSaveChangesBtn);
		eleSaveChangesBtn.click();
		obj.threadWait();
	
	//Validating save message
		String saveMessage=driver.findElementByXPath("//div[@class='alert-message']").getText();
		System.out.println(saveMessage);
		
	//Click on Ok Button	
		driver.findElementByXPath("//button[@category='alert-button']").click();
		System.out.println("First name changed successfully");
		obj.threadWait();
		
	//Click on the settings back	
		eleSettings.click();
		obj.threadWait();
		
	//Logout from the user
		obj.logout();
		
	//Re login and verify the updated first and last name. 
		
		obj.login(username, password);
		String updatedName=driver.findElementByXPath("//label").getText();
		String[] splitName=updatedName.split(" ");
		
		if(splitName[0].equals(firstName) && splitName[1].equals(lastName))
		{
			System.out.println("****Edit Profile successfully done****");
		}
		
	}

}
