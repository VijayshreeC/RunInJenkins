package com.PageObjects;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2PageObject {

	WebDriver driver;
	@FindBy(name = "q")
	WebElement googleSearchBox;

	@FindBy(xpath = "//div[@class='rc']//a")
	List<WebElement> firstLink;

	
	
	public Test2PageObject(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}


	
	
	public void EnterSeachText() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		googleSearchBox.sendKeys("Automation");
		wait.until(ExpectedConditions.textToBePresentInElementValue(googleSearchBox, "Automation"));
		googleSearchBox.sendKeys(Keys.ENTER);

	}

	public boolean clickOnFirstClick() {
		firstLink.get(0).click();
		if (driver.getTitle().contains("Automation - Wikipedia")) {
			return true;
		}
		return false;
	}

}
