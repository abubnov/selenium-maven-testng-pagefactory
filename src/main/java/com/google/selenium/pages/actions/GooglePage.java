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


		if(googleElements.googleFrame.isDisplayed()) {				
			System.out.println("iFrame is Visibale");
			//Switch to iFrame	
			driver.switchTo().frame(googleElements.googleFrame); 
			System.out.println("Switch to iFrame");
			//Click on Agree button	
			BasePage.clickOnElement(googleElements.agreeBtn);
			//Switch back to browser	
			BasePage.switch2DefaultContent();
			System.out.println("Switch to browser");
			BasePage.pageLoad(20, TimeUnit.SECONDS);
		}else {
			System.out.println("iFrame is Invisible");
		}			
	}


	public SearchResultPage searchFunction(String searchText){	    	
		BasePage.wait4ElementClickable(googleElements.searchField, 10);
		BasePage.enterText(googleElements.searchField,searchText);		
		BasePage.submitElement(googleElements.searchField);	
		BasePage.pageLoad(20, TimeUnit.SECONDS);		
		return PageFactory.initElements(driver, SearchResultPage.class);
	}


}
