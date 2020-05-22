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
	
	public static final String USERNAME = "Admin_00";
	  public static final String ACCESS_KEY = "b94209bf-d332-40b2-9487-66354d6d2de9";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	@Parameters("browser")
	
	@BeforeClass

	public void openBrowser(String browsername) throws IOException, InterruptedException {
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
		} 
		else if (browsername.equals("firefox")) {
			System.out.println("Running in firefox");
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
			driver = new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"), dc);
			System.out.println("RUNNING TESTS IN REMOTE CHROME BROWSER");
			System.out.println();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browsername.equals("saucechrome")) {
			System.out.println("Running in Saucelabs");
			System.out.println(URL);
			DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
		    caps.setCapability("name", "Test1");
		    caps.setCapability("buildNumber", "3.0");
		 
		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    driver.get(url);
			driver.manage().window().maximize();
}
		
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
