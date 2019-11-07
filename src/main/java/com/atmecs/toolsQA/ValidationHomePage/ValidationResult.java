package com.atmecs.toolsQA.ValidationHomePage;

import org.testng.Assert;
import com.atmecs.toolsQA.logreports.LogReports;

public class ValidationResult {
	static LogReports report = new LogReports();

	public static boolean validateData(String actual, String expected, String message) {
		try {
			/*
			 * printing actual and expected values
			 */
			Assert.assertEquals(actual, expected);
			report.info("Passed : " + message + " : " + " Actual data : " + actual + " Expected data : " + expected);
			return true;
		} catch (AssertionError assertionError) {
			report.info("failed : " + message + " : " + " Actual data : " + actual + " Expected data : " + expected);
			return false;
		}
	}
}
