package com.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Manager.DriverManager;
import com.Manager.DriverManagerFactory;
import com.Manager.DriverType;

public class BaseUtils {
	public WebDriver driver;
	DriverManager driverManager;

	
	String url = "https://www.google.com/";
	@BeforeClass // runs with same driver instance
	@Parameters("browser")
	public void setup(String browserName) {
		getLocalDriver(browserName);
	}

	public WebDriver getLocalDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
			driver = driverManager.getDriver();
			
			driver.manage().window().maximize();
			
			
		}

		return driver;
	}

	@AfterClass
	public void teardown() {
		driverManager.quitDriver();
	}
}
