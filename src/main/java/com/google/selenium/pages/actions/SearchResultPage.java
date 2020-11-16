package com.google.selenium.pages.actions;

public class SearchResultPage {
	
	 public SearchResultPageElements searchresultElements;
		
		public SearchResultPage() {
			this.searchresultElements = new SearchResultPageElements();
			PageFactory.initElements(driver, this.searchresultElements);
		}

}
