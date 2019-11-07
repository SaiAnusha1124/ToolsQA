package com.atmecs.toolsQA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.atmecs.toolsQA.helpers.LocatorType;

public class ScrollDownAction {

	public void scrollDown(WebDriver driver, LocatorType locator, String locatorValue) {

		switch (locator) {
		case CLASSNAME:
			driver.findElement(By.className(locatorValue));
			break;

		case CSSSELECTOR:
			driver.findElement(By.cssSelector(locatorValue));
			break;

		case ID:
			driver.findElement(By.id(locatorValue));
			break;

		case LINKTEXT:
			driver.findElement(By.linkText(locatorValue));
			break;

		case NAME:
			driver.findElement(By.name(locatorValue));
			break;

		case PARTIALLINKTEXT:
			driver.findElement(By.partialLinkText(locatorValue));
			break;

		case TAGNAME:
			driver.findElement(By.tagName(locatorValue));
			break;

		case XPATH:
			driver.findElement(By.xpath(locatorValue));
			break;

		default:
			break;
		}
	}
}
