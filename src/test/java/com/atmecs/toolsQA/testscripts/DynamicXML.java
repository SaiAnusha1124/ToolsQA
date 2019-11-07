package com.atmecs.toolsQA.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicXML {
	String browsername;
	Properties properties;
	String browser;

	@SuppressWarnings("deprecation")
	@Test
	public void base() throws IOException {
		// browsername = ReadLocatorsFile.loadProperty(ConstantsFilePaths.CONFIG_FILE);
		String[] browser = browsername.split(",");

		XmlSuite xmlsuite = new XmlSuite();
		xmlsuite.setName("suitename");
		xmlsuite.setVerbose(2);
		xmlsuite.setThreadCount(3);
		xmlsuite.setParallel("tests");
		for (String element : browser) {

			XmlTest xmltest = new XmlTest(xmlsuite);
			Map<String, String> parameter = new HashMap<String, String>();
			parameter.put("Browser", element);
			xmltest.setParameters(parameter);
			xmltest.setName("Test validate " + element);

			XmlClass homePage = new XmlClass(TestHomePage.class);
            // XmlClass productDetail = new XmlClass(.class);
			List<XmlClass> list = new ArrayList<XmlClass>();
			list.add(homePage);
            // list.add(productDetail);
			xmltest.setXmlClasses(list);

		}

		TestNG testng = new TestNG();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlsuite);
		testng.setXmlSuites(suites);

		testng.run();

	}
}
