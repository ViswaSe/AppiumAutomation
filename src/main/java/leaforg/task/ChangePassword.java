package leaforg.task;

import java.net.MalformedURLException;

public class ChangePassword extends BaseClass {

	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{
		
		String username="rajkumar@testleaf.com";
		String password="TestLeaf@123";
		
		BaseClass obj = new BaseClass();
		obj.preLogin();
		obj.switchToWebContext();
		obj.login(username,password);
		obj.afterLogin();
		
		String currentPassword=password;
		String newPassword="Leaf@123";
		String newPasswordAgain=newPassword;
		
		driver.findElementByXPath("(//a[contains(@class,'tab-button')])[3]").click();
		obj.threadWait();
		driver.findElementByXPath("(//ion-icon[@name='arrow-forward'])[4]").click();
		obj.threadWait();
		driver.findElementByXPath("//input[@placeholder='Current Password']").sendKeys(currentPassword);
		driver.findElementByXPath("//input[@placeholder='New Password']").sendKeys(newPassword);
		driver.findElementByXPath("//input[@placeholder='New Password Again']").sendKeys(newPasswordAgain);		
		
	//changing password
		obj.threadWait();
		driver.findElementByXPath("//span[text()='Change Password']").click();
		obj.threadWait();
		
		String popupMessage=driver.findElementByXPath("//div[@class='alert-message']").getText();
		System.out.println(popupMessage);
		driver.findElementByXPath("//button[@category='alert-button']").click();
		obj.threadWait();
		
	//Logging out after password resetted
		obj.logout();
		obj.login(username, password);
		
	//Capturing the error messsage	
		String errorMessage=driver.findElementByXPath("//ion-label[contains(text(),'password')]").getText();
		System.out.println(errorMessage);
		driver.findElementByXPath("//span[contains(text(),'Back')]").click();
		obj.threadWait();
		
	//Re login with new password
		obj.login(username, newPassword);
		obj.threadWait();
		
		System.out.println("*****Password Reset done successfully****");
		
	}
}
