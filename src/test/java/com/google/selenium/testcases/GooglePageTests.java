package com.google.selenium.testcases;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
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
	private static Logger LOGGER = LogManager.getLogger(GooglePageTests.class);
	GooglePage google;

	@BeforeClass
	public void openHomePage() {
		LOGGER.info("-------> Started : ");
		google = new GooglePage();
		google.handlingFrame();
		LOGGER.info("------->Finished : ");
	}


	@Test
	public void checkOpenedHomePage() {	
		LOGGER.info("-------> Started : ");
		BasePage.validatePageTitle(TestDate.homeTitle);	
		LOGGER.info("------->Finished : ");
	}

	@Test
	public void checkGmail() {	
		LOGGER.info("-------> Started : ");
		boolean gmailLinkPresent = google.googleElements.gmailLink.isDisplayed();		
		AssertionHelper.verifyTrue(gmailLinkPresent);
		AssertionHelper.verifyText(TestDate.gmailLinkName, google.googleElements.gmailLink.getText());
		AssertionHelper.verifyText(TestDate.gmailUrl, google.googleElements.gmailLink.getAttribute("href"));		
		LOGGER.info("------->Finished : ");
	}



	@Test
	public void checkGoogleAppsLink() {	
		LOGGER.info("-------> Started : ");
		boolean googleAppsLinkPresent = google.googleElements.googleApps.isDisplayed();		
		AssertionHelper.verifyTrue(googleAppsLinkPresent);	
		AssertionHelper.verifyText(TestDate.gmailUrl, google.googleElements.googleApps.getAttribute("href"));
		LOGGER.info("------->Finished : ");
	}

	@Test
	public void checkSearchFiledIsDisplayed() {		
		LOGGER.info("-------> Started : ");
		boolean searchFiledPresent = google.googleElements.searchField.isDisplayed();		
		AssertionHelper.verifyTrue(searchFiledPresent);	
		LOGGER.info("------->Finished : ");
	}


	@Test
	public void checkSearchWithExistingText() {
		LOGGER.info("-------> Started : ");
		SearchResultPage searchresult = google.searchFunction(TestDate.searchExistingText);					
		searchresult.validateSearchResult();
		LOGGER.info("------->Finished : ");
	}


}
