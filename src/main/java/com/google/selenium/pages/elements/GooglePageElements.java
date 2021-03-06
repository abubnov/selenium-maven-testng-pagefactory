package com.google.selenium.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePageElements {

	@FindBy(name = "q" )
	public WebElement searchField;

	@FindBy(id = "introAgreeButton")
	public WebElement agreeBtn;

	@FindBy(xpath = "//*[@id='cnsw']/iframe")
	public WebElement googleFrame;	

	@FindBy(xpath = "//*[text()='Gmail']")
	public WebElement gmailLink;	

	@FindBy(xpath = "//*[@id='gbwa']/div/a")
	public WebElement googleApps;	



}
