package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.onePlusPage;
import utils.utils;

public class testcases {
	public static final String USERNAME = "aniketkhaire_7wbodv"  ;
	public static final String AUTOMATE_KEY =  "Tn6NX5noWEGQ5QLJTB3J";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	WebDriver driver;
	onePlusPage op_page;
	utils utility;
	
	DesiredCapabilities caps = new DesiredCapabilities();	

	@Parameters("browserName")
	@BeforeTest
		public void setUp(String browserName) throws IOException {
			if (browserName.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\latestchromedriver\\chromedriver.exe");
			//	driver = new ChromeDriver();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "90.0");
			    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "88.0");
				//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\firefox\\geckodriver.exe");
			    driver = new RemoteWebDriver(new java.net.URL(URL), caps);

			//	driver = new FirefoxDriver();
			} else {
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Edge");
				caps.setCapability("browser_version", "92.0");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.5.2");
			    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(utils.getPropertyValues("URL"));
			driver.manage().window().maximize();
	}
	
	@Test()
		public void Tc_001_Oneplus() throws IOException, InterruptedException {
			op_page = new onePlusPage(driver);
			op_page.searchMobile(utils.getPropertyValues("MobileName"));
			op_page.clickSearch();
			op_page.results();
		}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
