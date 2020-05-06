package com.Testcases;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BrowserClass {

	public WebDriver driver;

	String url = "https://www.google.com/";
	
	@Parameters("browser")
	
	@BeforeClass

	public void openBrowser(String browsername) throws IOException, InterruptedException {
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
		} 
		else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} 
		else if (browsername.equals("remotechrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://192.168.0.104:4430/wd/hub"), dc);
			System.out.println("RUNNING TESTS IN REMOTE CHROME BROWSER");
			System.out.println();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
