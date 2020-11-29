package com.google.selenium.framework;

import org.testng.Assert;

public class AssertionHelper {

	public static void verifyText(String str1, String str2){		
		Assert.assertEquals(str1, str1);
		System.out.println("Actual string is '" + str1 + "'");
		System.out.println("Expected string is '" + str2 + "'");
	}

	public static void verifyTrue(boolean status){
		Assert.assertTrue(status);
		System.out.println("Verification is passed");
	}

}
