package com.google.selenium.pages.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.google.selenium.framework.BasePage;
import com.google.selenium.pages.elements.GooglePageElements;

public class GooglePage extends BasePage{
	
public GooglePageElements googleElements;
	
	public GooglePage() {
		this.googleElements = new GooglePageElements();		
		PageFactory.initElements(driver, this.googleElements);
	}
	
public void handlingFrame() {	
		
		//BasePage.wait4ElementVisibleWithPollingTime(googleElements.googleFrame, 20, 500);
		BasePage.wait4Element(googleElements.googleFrame, 20);
			if(googleElements.googleFrame.isDisplayed()) {				
			System.out.println("iFrame is Visibale");
			//Switch to iFrame	
			BasePage.wait4frameToBeAvailableAndSwitchToIt(googleElements.googleFrame, 15);	
			 System.out.println("Switch to iFrame");
			 //Click on Agree button	
			 BasePage.clickOnElement(googleElements.agreeBtn);
			 //Switch back to browser	
			 BasePage.switch2DefaultContent();
			 System.out.println("Switch to browser");			
		}else {
			System.out.println("iFrame is Invisible");
		}			
	}
	
	
    public SearchResultPage searchFunction(){	    	
    	BasePage.wait4ElementClickable(googleElements.searchField, 10);
		BasePage.enterText(googleElements.searchField,"bbc.com");		
		BasePage.submitElement(googleElements.searchField);	
		BasePage.pageLoad(20, TimeUnit.SECONDS);		
		return PageFactory.initElements(driver, SearchResultPage.class);
	    }
	

}
