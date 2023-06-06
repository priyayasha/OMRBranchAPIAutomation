package com.stepdefinition;

import com.base.UtilityClass;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

/**
 * 
 * @author priya
 * @see This class is used to run predefined methods after scenario
 * @since 02-06-2023
 *
 */
public class HooksClass extends UtilityClass {
	static Scenario scenario;

	@After
	public void afterScenario(Scenario sc) {
		scenario = sc;
		scenario.log(getBodyAsPrettyString(response));

	}
}
