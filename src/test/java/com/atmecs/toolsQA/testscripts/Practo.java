package com.atmecs.toolsQA.testscripts;

import java.util.Properties;

import org.testng.annotations.Test;

import com.atmecs.toolsQA.ValidationHomePage.PractoValidation;
import com.atmecs.toolsQA.constants.ConstantsFilePaths;
import com.atmecs.toolsQA.helpers.LocatorType;
import com.atmecs.toolsQA.pages.ClickOnElementAction;
import com.atmecs.toolsQA.pages.SendKeysAction;
import com.atmecs.toolsQA.testbase.TestBase;
import com.atmecs.toolsQA.utils.ReadExcelFile;
import com.atmecs.toolsQA.utils.ReadLocatorsFile;

public class Practo extends TestBase {

	static Properties properties;
	static Properties properties1;
	static String actualskin;
	ClickOnElementAction click = new ClickOnElementAction();
	SendKeysAction sendkeys = new SendKeysAction();
	ReadExcelFile readexcel = new ReadExcelFile();

	@Test
	public void validating() throws Exception {
		
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);


		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-practo"));
		log.info("clicking pharmacy");
		PractoValidation.verifyingPracto();
		
//		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-skin"));
//		log.info("clicking skin");
//		actualskin = driver.findElement(By.xpath((properties.getProperty("loc-verify-skin")))).getText();
//		ValidationResult.validateData(actualskin, properties1.getProperty("expectedskin"),"loc-verify-skin");

		

	}
}