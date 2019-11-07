package com.atmecs.toolsQA.logreports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.atmecs.toolsQA.constants.ConstantsFilePaths;

public class LogReports {
	Logger log = null;

	public LogReports() {
		getlogger();
		log = Logger.getLogger(LogReports.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(ConstantsFilePaths.LOG4J_FILE);
	}

	public void info(String message) {
		log.info(message);
	}
}
