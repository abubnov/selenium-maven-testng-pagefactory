package com.google.selenium.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.selenium.framework.BaseTest;
import com.google.selenium.framework.ListenerHelper;
import com.google.selenium.framework.TestDate;
import com.google.selenium.pages.actions.GooglePage;
import com.google.selenium.pages.actions.SearchResultPage;

@Listeners(ListenerHelper.class)
public class ResultPageTest extends BaseTest{
	private static Logger LOGGER = LogManager.getLogger(ResultPageTest.class);
	GooglePage google;
	SearchResultPage searchResult;


	@BeforeClass
	public void openHomePage() {	
		LOGGER.info("-------> Started : ");
		google = new GooglePage();
		google.handlingFrame();
		LOGGER.info("------->Finished : ");
	}


	@Test
	public void c() {	
		LOGGER.info("-------> Started : ");
		SearchResultPage searchresult = google.searchFunction(TestDate.searchExistingCapitalText);
		searchresult.validateSearchResult();
		LOGGER.info("------->Finished : ");		
	}


}
