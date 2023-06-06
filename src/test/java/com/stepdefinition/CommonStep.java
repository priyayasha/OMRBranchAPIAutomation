package com.stepdefinition;

import org.junit.Assert;
import com.base.UtilityClass;
import io.cucumber.java.en.Then;

/**
 * 
 * @author priya
 * @see purpose of this class is to have commonsteps
 * @since 02-06-2023
 */
public class CommonStep extends UtilityClass {
	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int expStatusCode) {
		int actStatusCode = TC1_LoginStep.globalData.getStatusCode();
		System.out.println(actStatusCode);

		Assert.assertEquals("Verify status code", expStatusCode, actStatusCode);

	}

}
