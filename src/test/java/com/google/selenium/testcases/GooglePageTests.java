package com.google.selenium.testcases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.selenium.framework.AssertionHelper;
import com.google.selenium.framework.BasePage;
import com.google.selenium.framework.BaseTest;
import com.google.selenium.framework.ListenerHelper;
import com.google.selenium.framework.TestDate;
import com.google.selenium.pages.actions.GooglePage;
import com.google.selenium.pages.actions.SearchResultPage;

@Listeners(ListenerHelper.class)
public class GooglePageTests extends BaseTest{
	GooglePage google;

	@BeforeClass
	public void openHomePage() {	
		google = new GooglePage();
		google.handlingFrame();
	}


	@Test
	public void checkOpenedHomePage() {		
		BasePage.validatePageTitle(TestDate.homeTitle);		
	}

	@Test
	public void checkGmailLinkIsDisplayed() {		
		boolean gmailLinkPresent = google.googleElements.gmailLink.isDisplayed();		
		AssertionHelper.verifyTrue(gmailLinkPresent);		
	}
	
	
	
	@Test
	public void checkGoogleAppsLinkIsDisplayed() {		
		boolean googleAppsLinkPresent = google.googleElements.googleApps.isDisplayed();		
		AssertionHelper.verifyTrue(googleAppsLinkPresent);		
	}
	
	@Test
	public void checkSearchFiledIsDisplayed() {		
		boolean searchFiledPresent = google.googleElements.searchField.isDisplayed();		
		AssertionHelper.verifyTrue(searchFiledPresent);		
	}
		

	@Test
	public void googleSearchTest() {		
		SearchResultPage searchresult = google.searchFunction();					
		searchresult.validateSearchResult();						
	}


}
