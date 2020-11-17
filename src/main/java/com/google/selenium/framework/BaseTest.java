package com.google.selenium.framework;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	public static Date d = new Date();
    public static String timeStamp = d.toString().replace(":", "_").replace(" ", "_");
    public static String filePath = "screenshots/" + timeStamp + "/";

	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {
		BasePage.initConfiguration();		
	}

	@AfterSuite(alwaysRun = true)
	public void closeDriver() {		
		BasePage.closeDriver();
	}
	
	public void screenshotOnFailedTest(String testMethodName) {
        File scrFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filePath + testMethodName + ".jpg"));
            scrFile.delete();
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("Screenshot could not be created!");
            e.printStackTrace();
        }
    }

}
