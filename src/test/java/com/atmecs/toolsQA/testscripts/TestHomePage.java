package com.atmecs.toolsQA.testscripts;

import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.atmecs.toolsQA.ValidationHomePage.VerifyHomePageContent;
import com.atmecs.toolsQA.constants.ConstantsFilePaths;
import com.atmecs.toolsQA.extentreports.ExtentReport;
import com.atmecs.toolsQA.helpers.LocatorType;
import com.atmecs.toolsQA.pages.ClickOnElementAction;
import com.atmecs.toolsQA.pages.SendKeysAction;
import com.atmecs.toolsQA.testbase.TestBase;
import com.atmecs.toolsQA.utils.ReadExcelFile;
import com.atmecs.toolsQA.utils.ReadLocatorsFile;

public class TestHomePage extends TestBase {
	Properties properties;
	ClickOnElementAction click = new ClickOnElementAction();
	SendKeysAction sendkeys = new SendKeysAction();
	ReadExcelFile readexcel = new ReadExcelFile();

	@DataProvider(parallel = true)
	public Object[][] inputValues() {
		Object data[][] = readexcel.readExcel("Sheet1", ConstantsFilePaths.TESTDATA_FILE1);
		return data;
	}

	@Test(dataProvider = "inputValues", priority = 1)
	public void testingDemoPage(String firstname, String lastname, String date) throws Exception {

		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-clickheading-HOME"));
		try {
			VerifyHomePageContent.verifyingHomePage();
		} catch (Exception e) {
			log.info("Unable to locate first Heading in Home page");
			e.printStackTrace();
		}
		log.info("***Successfully validating Content of Home Page***");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-click-demosites"));
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-click-automationform"));
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-clickcookies-accept"));
		Thread.sleep(10000);
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-firstname"), firstname);
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-lastname"), lastname);
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-clickcheckbox-female"));
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-clickcheckbox-experience"));
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-date"), date);
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-clickcheckbox-profession"));
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-clickcheckbox-automationtool"));
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("window.scrollTo(0,-500, document.body.scrollHeight)");
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-dropdown-europe"));
		log.info("Entered name,experience,profession,automation tool details");
		log.info("***Sucessfully completed details of subscriber***");
		ExtentReport.reportLog("testingDemoPage", "Failed");		
	}
}
