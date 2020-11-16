package com.google.selenium.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.selenium.framework.BasePage;
import com.google.selenium.pages.actions.GooglePage;
import com.google.selenium.pages.actions.SearchResultPage;

public class GoogleTests {
	
	@BeforeMethod
	public void openHomePage() {
		BasePage.initConfiguration();		
	}
	
		
	@Test
	public void googleSearchTest() {	
		GooglePage google = new GooglePage();
		google.handlingFrame();
		SearchResultPage searchresult = google.searchFunction();					
		searchresult.validateSearchResult();						
	}
	
	@AfterMethod
	public void closeDriver() {		
		BasePage.closeDriver();
	}


}
