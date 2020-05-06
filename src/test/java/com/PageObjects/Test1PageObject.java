package com.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test1PageObject {
	
	WebDriver driver;
	@FindBy(name="q")
	WebElement googleSearchBox;
	
	@FindBy(xpath ="//div[@class='rc']//a")
	List<WebElement> firstLink;
	
	
	public Test1PageObject(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void enterSeachText() {
		googleSearchBox.sendKeys("Selenium");
		googleSearchBox.sendKeys(Keys.ENTER);
		
	}
	public boolean clickOnFirstClick() {
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		firstLink.get(0).click();
		if(driver.getTitle().contains("Selenium")){
			driver.navigate().back();
			googleSearchBox.clear();
			
			return true;
			
		}
		return false;
	}
	
	

	
}
