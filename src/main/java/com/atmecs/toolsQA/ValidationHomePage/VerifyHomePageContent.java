package com.atmecs.toolsQA.ValidationHomePage;

import java.util.Properties;
import org.openqa.selenium.By;
import com.atmecs.toolsQA.constants.ConstantsFilePaths;
import com.atmecs.toolsQA.testbase.TestBase;
import com.atmecs.toolsQA.utils.ReadLocatorsFile;

public class VerifyHomePageContent extends TestBase {
	static String xpath;
	static Properties properties;
	static Properties properties1;
	static String actualfirstheading,actualsecondheading,actualthirdheading,actualfourthheading;

	public static void verifyingHomePage() throws Exception {
		// read locators from locators file
		properties = ReadLocatorsFile.loadProperty(ConstantsFilePaths.LOCATOR_FILE);
		properties1 = ReadLocatorsFile.loadProperty(ConstantsFilePaths.TESTDATA_FILE);

		actualfirstheading = driver.findElement(By.xpath((properties.getProperty("loc-xpath-verifyhomepage-firstheading")))).getText();
		ValidationResult.validateData(actualfirstheading, properties1.getProperty("expectedfirstheading"),"Verifying first heading in Home Page");
		
		actualsecondheading = driver.findElement(By.xpath((properties.getProperty("loc-xpath-verifyhomepage-secondheading")))).getText();
		ValidationResult.validateData(actualsecondheading, properties1.getProperty("expectedsecondheading"),"Verifying second heading in Home Page");
		
		actualthirdheading = driver.findElement(By.xpath((properties.getProperty("loc-xpath-verifyhomepage-thirdheading")))).getText();
		ValidationResult.validateData(actualthirdheading, properties1.getProperty("expectedthirdheading"),"Verifying third heading in Home Page");
		
		actualfourthheading = driver.findElement(By.xpath((properties.getProperty("loc-xpath-verigyhomepage-fourthheading")))).getText();
		ValidationResult.validateData(actualfourthheading, properties1.getProperty("expectedfourthheading"),"Verifying fourth heading in Home Page");
	}
}
