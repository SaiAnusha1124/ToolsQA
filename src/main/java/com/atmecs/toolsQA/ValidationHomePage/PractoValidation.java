package com.atmecs.toolsQA.ValidationHomePage;

import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.atmecs.toolsQA.constants.ConstantsFilePaths;
import com.atmecs.toolsQA.helpers.LocatorType;
import com.atmecs.toolsQA.pages.ClickOnElementAction;
import com.atmecs.toolsQA.testbase.TestBase;
import com.atmecs.toolsQA.utils.ReadExcelFile;
import com.atmecs.toolsQA.utils.ReadLocatorsFile;

public class PractoValidation extends TestBase {
	static String xpath;
	static Properties properties;
	static Properties properties1;
	static ClickOnElementAction click = new ClickOnElementAction();
	static String actualskin,actualfamilycare,actualfitness,actualhair,actuallip,actualsexual,actualwomens,actualbaby;

	public static void verifyingPracto() throws Exception {
		// read locators from locators file
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);
		
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-skin"));
		log.info("clicking skin");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		actualskin = driver.findElement(By.xpath((properties.getProperty("loc-verify-skin")))).getText();
		ValidationResult.validateData(actualskin, properties1.getProperty("expectedskin"),"loc-verify-skin");
		
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-familycare"));
		actualfamilycare = driver.findElement(By.xpath((properties.getProperty("loc-verify-familycare")))).getText();
		ValidationResult.validateData(actualfamilycare, properties1.getProperty("expectedfamily"),"loc-verify-familycare");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-fitness"));
		actualfitness = driver.findElement(By.xpath((properties.getProperty("loc-verify-fitness")))).getText();
		ValidationResult.validateData(actualfitness, properties1.getProperty("expectedfitness"),"loc-verify-fitness");
		
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-hair"));
		actualhair = driver.findElement(By.xpath((properties.getProperty("loc-verify-hair")))).getText();
		ValidationResult.validateData(actualhair, properties1.getProperty("expectedhair"),"loc-verify-hair");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-lipcare"));
		actuallip = driver.findElement(By.xpath((properties.getProperty("loc-verify-lip")))).getText();
		ValidationResult.validateData(actuallip, properties1.getProperty("expectedlip"),"loc-verify-lip");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-sexual"));
		actualsexual = driver.findElement(By.xpath((properties.getProperty("loc-verify-sexual")))).getText();
		ValidationResult.validateData(actualsexual, properties1.getProperty("expectedsexual"),"loc-verify-sexual");

		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-womens"));
		actualwomens = driver.findElement(By.xpath((properties.getProperty("loc-verify-womens")))).getText();
		ValidationResult.validateData(actualwomens, properties1.getProperty("expectedwomens"),"loc-verify-womens");
		
		click.clickElement(driver, LocatorType.XPATH, properties.getProperty("loc-click-baby"));
		actualbaby = driver.findElement(By.xpath((properties.getProperty("loc-verify-baby")))).getText();
		ValidationResult.validateData(actualbaby, properties1.getProperty("expectedbaby"),"loc-verify-baby");
		
		
		String data[][]=ReadExcelFile.getUserData("./src/test/resources/testdata/expecteddata-toolsQA2.xlsx");
		
		for(int i=1;i<9;i++) {
			
			String locator= properties.getProperty("locatorlist").replace("***", i+"");
			click.clickElement(driver, LocatorType.XPATH, locator);	
			
			String breadcrum=driver.findElement(By.cssSelector((properties.getProperty("currentbreadcrum")))).getText();
			Assert.assertEquals(breadcrum, data[i-1][1]);
			log.info(" Validation Passed " + breadcrum);
			
		}
		
		
	}
}
