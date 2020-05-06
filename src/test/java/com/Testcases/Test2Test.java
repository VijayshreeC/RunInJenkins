package com.Testcases;

import org.testng.annotations.Test;

import com.PageObjects.Test2PageObject;

public class Test2Test extends BrowserClass {
	//click Automation
	
	
	@Test
	public void executeFirst2Testcase() throws InterruptedException {
		
		Test2PageObject tobj2= new Test2PageObject(driver);
		tobj2.EnterSeachText();
		tobj2.clickOnFirstClick();
	}

}
