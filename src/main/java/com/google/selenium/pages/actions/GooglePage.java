package com.google.selenium.pages.actions;

public class GooglePage {
	
public GooglePageElements googleElements;
	
	public GooglePage() {
		this.googleElements = new GooglePageElements();		
		PageFactory.initElements(driver, this.googleElements);
	}

}
