package leaforg.task;

import java.net.MalformedURLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EditParticipantDetails extends BaseClass{

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		String username="rajkumar@testleaf.com";
		String password="Leaf@123";

		//Perform Login
		BaseClass obj=new BaseClass();
		obj.preLogin();
		obj.login(username, password);

		//click on settings icon
		WebElement eleSettings=driver.findElementByXPath("//ion-icon[@aria-label='settings']");
		eleSettings.click();
		obj.threadWait();

		//click on the participant details
		driver.findElementByXPath("(//ion-icon[@aria-label='arrow forward'])[2]").click();
		obj.threadWait();

		//Edit participant ID and organization name
		String participantId="28541786";

		WebElement eleParticipantId=driver.findElementByXPath("//input[@placeholder='Participant ID']");
		eleParticipantId.clear();
		eleParticipantId.sendKeys(participantId);

		/*WebElement eleParticipantId=driver.findElementByXPath("//ion-input[@placeholder='Participant ID']");
		Actions builder = new Actions(driver);
		builder.doubleClick(eleParticipantId).sendKeys(Keys.DELETE).sendKeys(participantId).perform();*/

		//click on save changes button
		driver.findElementByXPath("//span[text()='SAVE CHANGES']").click();
		obj.threadWait();

		//click on save popup and display the message

		String eleSaveMessage=driver.findElementByXPath("//div[@class='alert-message']").getText();
		System.out.println(eleSaveMessage);
		driver.findElementByXPath("//button[@category='alert-button']").click();
		obj.threadWait();

		//click on settings button again
		eleSettings.click();
		obj.threadWait();

		//Perform Logout
		obj.logout();

		//Perform relogin and validate the changes
		obj.login(username, password);

		String updatedParticipantID=driver.findElementByXPath("(//label[@class='prmlbl'])[2]").getText();
		System.out.println(updatedParticipantID);
		if(updatedParticipantID.contains(participantId))
		{
			System.out.println("****Edit Participant Details successfully done****");
		}


	}

}
