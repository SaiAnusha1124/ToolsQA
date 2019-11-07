package com.atmecs.toolsQA.constants;

import java.io.File;

public class ConstantsFilePaths {
	/*
	 * In this class, required file pathe are saved
	 */

	public final static String homeDir = System.getProperty("user.dir") + File.separator;

	public final static String RESOURCES_HOME = homeDir + "src" + File.separator + "test" + File.separator + "resources"
			+ File.separator;

	public final static String LIB_HOME = homeDir + "lib" + File.separator;

	public final static String CHROME_FILE = LIB_HOME + "chromedriver.exe";

	public final static String FIREFOX_FILE = LIB_HOME + "geckodriver.exe";

	public final static String IE_FILE = LIB_HOME + "IEDriverServer.exe";

	public final static String CONFIG_FILE = RESOURCES_HOME + "config" + File.separator + "config.properties";

	public static final String LOCATOR_FILE = RESOURCES_HOME + "locators" + File.separator + "locators.properties";

	public final static String TESTDATA_FILE = RESOURCES_HOME + "testData" + File.separator + "testdata.properties";

	public final static String LOG4J_FILE = RESOURCES_HOME + "log4j" + File.separator + "log4j.properties";

	public final static String TESTDATA_FILE1 = RESOURCES_HOME + "testData" + File.separator + "inputs-toolsQA.xlsx";

	public final static String EXTENT_REPORTFOLDER = homeDir + "extentreport" + File.separator;

	public final static String EXTENT_REPORTFILE = "C:\\Users\\saianusha.podichervu\\eclipse-workspace\\Automation-ToolsQA\\extentreport\\extentreport.html";

}
