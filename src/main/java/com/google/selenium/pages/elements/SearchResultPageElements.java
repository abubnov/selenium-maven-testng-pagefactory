package com.google.selenium.pages.elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPageElements {
	
	 @FindBy(css = "h3.r > a")
	 private List<WebElement> resultEements;
	 
	 public List<WebElement> getResultsElements() {
		    return resultEements;
	 }
	 
	 @FindBy(css = "#res .g")
	  private List<WebElement> results;
	 
	 public List<WebElement> getResults() {
		    return results;
	 }

}
