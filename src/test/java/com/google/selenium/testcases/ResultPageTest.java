package com.google.selenium.testcases;

import org.testng.annotations.AfterClass;
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
public class ResultPageTest extends BaseTest{
	GooglePage google;
	SearchResultPage searchResult;
	
		
	@BeforeClass
	public void openHomePage() {		
		google = new GooglePage();
		google.handlingFrame();
	}


	@Test
	public void resultPageTest() {		
		SearchResultPage searchresult = google.searchFunction();
		searchresult.validateSearchResult();
		
	}


}
