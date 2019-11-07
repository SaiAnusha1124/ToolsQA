package com.atmecs.toolsQA.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.atmecs.toolsQA.constants.ConstantsFilePaths;

public class WebTable {

	static WebDriver driver;

	@Test
	public void dynamicWebTable() {

		System.setProperty("webdriver.chrome.driver", ConstantsFilePaths.CHROME_FILE);
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		int rowCount = rows.size();
		System.out.println(rowCount);
		String beforeXpath = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[1]";
		for (int i = 2; i <= rowCount; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		System.out.println("-----------------------");
		for (int i = 2; i <= rowCount; i++) {
			String afterXpath1 = "]/td[2]";
			String actualXpath = beforeXpath + i + afterXpath1;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		System.out.println("------------------------");
		for (int i = 2; i <= rowCount; i++) {
			String afterXpath2 = "]/td[3]";
			String actualXpath = beforeXpath + i + afterXpath2;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}

//		  System.out.println("------------------------"); 
//		  [@id="customers"]/tbody/tr[2]
//		  [@id="customers"]/tbody/tr[3] 
//		  [@id="customers"]/tbody/tr[4] 

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		int colCount = columns.size();
		System.out.println(colCount);
		String beforeXpath1 = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath3 = "]";

		for (int i = 2; i <= colCount; i++) {
			String actualXpath = beforeXpath1 + i + afterXpath3;
			WebElement element = driver.findElement(By.xpath(actualXpath));
			System.out.println(element.getText());
		}
		
		driver.manage().window().maximize();
	}
}
