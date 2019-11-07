package com.atmecs.toolsQA.testbase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.atmecs.toolsQA.constants.ConstantsFilePaths;
import com.atmecs.toolsQA.logreports.LogReports;
import com.atmecs.toolsQA.utils.ReadLocatorsFile;

public class TestBase {
	Properties baseProperty;
	String url;
	String browser;
	String normal;
	public static WebDriver driver;
	public static LogReports log = new LogReports();

	@Parameters({ "Browser" })
	@BeforeTest
	public void initializeBrowser(String browsertype) {

		baseProperty = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
		url = baseProperty.getProperty("url");
		browser = baseProperty.getProperty("browserType");
		normal = baseProperty.getProperty("normal");
		if (normal.equalsIgnoreCase("normal")) {
			if (browsertype.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ConstantsFilePaths.CHROME_FILE);
				driver = new ChromeDriver();
				log.info("Chrome is Started");

			} else if (browsertype.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ConstantsFilePaths.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("Firefox is Started");

			} else if (browsertype.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", ConstantsFilePaths.IE_FILE);
				driver = new InternetExplorerDriver();
				log.info("IE is Started");

			}
		} else {
			try {
				driver = TestGridConnection.getDriver(browsertype);
				System.out.println(browsertype);

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit(); // closes the opened browser

	}
}
