package com.google.selenium.framework;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	public static WebDriver driver;
	public static String browser;
	
	
	public static WebDriver initConfiguration() {	

		if(TestDate.browser.equals("firefox")){			
			driver = new FirefoxDriver();			
			}else if(TestDate.browser.equals("chrome")){	
			 driver = new ChromeDriver();
			 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
		}
		
		driver.get(TestDate.homeUrl);
	
		driver.manage().window().maximize();		
		implicitWait(TestDate.implicitWait, TimeUnit.SECONDS);	
		BasePage.pageLoad(20, TimeUnit.SECONDS);
								
		return driver;
	}
	
	 public static void closeDriver(){		 
		 driver.quit();		 
	}	
	 
	 public static void clickOnElement(WebElement element) {
			element.click();			
	}
	 
	 public static void submitElement(WebElement element) {
			element.submit();			
	}
	 
	 public static void enterText(WebElement element, String value) {
			element.sendKeys(value);
	}
	 
	//Switch to iFrame	
	 public static void switch2Frame(WebElement element) {
		 driver.switchTo().frame(element);
	 }
	 
	 //Switch back to browser
     public static void switch2DefaultContent() {
    	 driver.switchTo().defaultContent();
	 }
     
     public static String getTitle()
     {
         return driver.getTitle();
     }
     
     
     //Wait methods:
     
     public static void implicitWait(long timeout, TimeUnit unit) { 		
 		driver.manage().timeouts().implicitlyWait(timeout, unit);
 	}    
     
     public static void wait4ElementClickable(WebElement element, int timeOutInSeconds) { 		
 		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
 		wait.until(ExpectedConditions.elementToBeClickable(element)); 		
 	}
    
     public static void wait4frameToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) { 		
 		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
 		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));  
 	}
         
     public static void wait4Element(WebElement element, int timeOutInSeconds) { 		
 		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
 		wait.until(ExpectedConditions.visibilityOf(element)); 		
 	}
     
     public static void pageLoad(long timeout, TimeUnit unit){ 		
 		driver.manage().timeouts().pageLoadTimeout(timeout, unit); 		
 	}  
     
    //Validate title of page
     public static void validatePageTitle(String expectedTitle) {
    	
    	 String actualTitle = getTitle(); 		
 		AssertionHelper.verifyText(expectedTitle, actualTitle);
     }
}
