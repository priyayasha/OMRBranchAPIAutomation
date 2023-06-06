package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author priya
 * @see This class is to generate the reports
 * @since 02-06-2023
 */

public class Reporting {
	
	public static void generateReport(String jsonFile) {
		// String path =System.getProperty("user.dir");
		File file = new File("C:\\Users\\AADHAN\\eclipse-workspace\\OMRBranchAPIAutomation\\target");

		Configuration config = new Configuration(file, "OMRBranch");

		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Operating System", "Windows11");
		config.addClassifications("Sprint", "15");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, config);

		builder.generateReports();

	}
}
