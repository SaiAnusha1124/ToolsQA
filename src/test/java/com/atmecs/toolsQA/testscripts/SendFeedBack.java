package com.atmecs.toolsQA.testscripts;

import java.util.Properties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.atmecs.toolsQA.constants.ConstantsFilePaths;
import com.atmecs.toolsQA.extentreports.ExtentReport;
import com.atmecs.toolsQA.helpers.LocatorType;
import com.atmecs.toolsQA.pages.ClickOnElementAction;
import com.atmecs.toolsQA.pages.SendKeysAction;
import com.atmecs.toolsQA.testbase.TestBase;
import com.atmecs.toolsQA.utils.ReadExcelFile;
import com.atmecs.toolsQA.utils.ReadLocatorsFile;

public class SendFeedBack extends TestBase {
	Properties properties;
	Properties properties1;
	ClickOnElementAction click = new ClickOnElementAction();
	SendKeysAction sendkeys = new SendKeysAction();
	ReadExcelFile readexcel = new ReadExcelFile();

	@DataProvider
	public Object[][] possibleValues() throws Exception {
		Object data[][] = readexcel.readExcel("SecondPage", ConstantsFilePaths.TESTDATA_FILE1);
		return data;
	}
	@Test(dataProvider = "possibleValues")
	public void sendigFeedback(String name, String email, String phonenumber, String city, String country,
			String company) {
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-click-about"));
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-click-contactus"));
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-name"), name);
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-email"), email);
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-phoneno"), phonenumber);
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-city"), city);
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-country"), country);
		sendkeys.sendKeys(driver, LocatorType.XPATH, properties.getProperty("loc-xpath-sendkeys-company"), company);
		// ClickOnElementAction.clickElement(driver,
		// LocatorType.XPATH,properties.getProperty("loc-xpath-click-sendbutton"));
		log.info("***Succefully Entered Feedback Details***");
		ExtentReport.reportLog("sendigFeedback", "failed");
	}
}
