package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.report.Reporting;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags="",features = "src\\test\\resources", plugin = {"json:target\\output.json","pretty"},dryRun= false, glue = "com.stepdefinition", monochrome=true)

/**
 * 
 * @author priya
 * @see This class is to run the test scenarios
 * @since 02-06-2023
 */
public class TestRunnerClass {
	
	@AfterClass
	public static void afterClass() {

		Reporting.generateReport("C:\\Users\\AADHAN\\eclipse-workspace\\OMRBranchAPIAutomation\\target\\output.json");
	}
	

}
