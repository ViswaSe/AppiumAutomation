package com.leaforg.pages;

import com.leaforg.wrapper.AppSpecificMethods;

public class HomePage extends AppSpecificMethods {
	
	public HomePage verifyParticipantName(String participantName)
	{
		if(verifyTextString(participantName, "xpath", "//label[text()=' PARTICIPANT NAME ']/preceding-sibling::label[1]"))
		{
			reportStep("Participiant Name is matching with the given value: "+participantName,"pass");
		}
		else
		{
			reportStep("Could not verify the participiant Name","fail");
		}
		return this;
	}

}
