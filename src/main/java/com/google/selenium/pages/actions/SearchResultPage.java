package com.google.selenium.pages.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.selenium.framework.BasePage;
import com.google.selenium.pages.elements.SearchResultPageElements;
import com.google.selenium.utility.TestDate;

public class SearchResultPage extends BasePage{

	public SearchResultPageElements searchresultElements;

	public SearchResultPage() {
		this.searchresultElements = new SearchResultPageElements();
		PageFactory.initElements(driver, this.searchresultElements);
	}

	public void validateSearchResult() {
		BasePage.pageLoad(20, TimeUnit.SECONDS);

		System.out.println("Result Elements size  is :" + searchresultElements.getResultsElements().size());

		for(int i= 0 ; i < searchresultElements.getResultsElements().size() -1; i++){
			String actualLink = searchresultElements.getResultsElements().get(i).getAttribute("href");
			String actualLinkName = searchresultElements.getResultsElements().get(i).getText();
			WebElement currentResultElement = searchresultElements.getResultsElements().get(i);

			System.out.println(i + " Actual search Title is '" + actualLinkName  +"'");
			System.out.println(i + " Actual search Link is '" + actualLink +"'");


			if(actualLinkName.contains(TestDate.testLinkName)){				 
				System.out.println("Expected Site Name as '" + TestDate.testLinkName + "' is found in the search results successfuly.");
			}

			if(actualLink.contains(TestDate.testUrl)){
				BasePage.clickOnElement(currentResultElement);
				System.out.println("Expected Link as " + TestDate.testUrl + " is found in the search results successfuly.");
			}

			BasePage.pageLoad(20, TimeUnit.SECONDS);
			BasePage.validatePageTitle(TestDate.testTitle);

		}
	}	 	

}
