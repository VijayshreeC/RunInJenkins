package com.Testcases;

import org.testng.annotations.Test;

import com.PageObjects.Test1PageObject;

public class Test1Test extends BrowserClass{

	//Click Selenium

	
	@Test
	public void executeFirstTest() {
		
		Test1PageObject tobj1= new Test1PageObject(driver);
		tobj1.enterSeachText();
		tobj1.clickOnFirstClick();
		
	}
	
	/*
	 * @Test(priority = 2) public void executeSecondTestcase() { Test1PageObject
	 * tobj= new Test1PageObject(driver); tobj.clickOnFirstClick(); }
	 */
}
