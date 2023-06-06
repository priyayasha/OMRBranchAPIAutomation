package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.UtilityClass;
import com.endpoints.Endpoints;
import com.globals.GlobalData;
import com.pojo.login.Login_Output_Pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
/**
 * 
 * @author priya
 * @see purpose of this class is for login functionality
 * @since 02-06-2023
 */
public class TC1_LoginStep extends UtilityClass {
	static GlobalData globalData = new GlobalData();
	Response response;
/**
 * 
 * @author priya
 * @see purpose of this method is to add header
 * @since 02-06-2023
 */
	@Given("User add header")
	public void user_add_header() {
		addHeader("accept", "application/json");
	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to perform basic authentication
	 * @since 02-06-2023
	 */
	@When("User add basic authentication for login {string} and {string}")
	public void user_add_basic_authentication_for_login_and(String string, String string2)
			throws FileNotFoundException, IOException {
		addBasicAuth(getPropertiesFileValue("userName"), getPropertiesFileValue("password"));
	}
		/**
	 * 
	 * @author priya
	 * @see purpose of this method is to add endpoint
	 * @since 02-06-2023
	 */

	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String reqType) {
		response = addReqType("POST", Endpoints.POSTMANBASICAUTH);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		globalData.setStatusCode(statusCode);

	}
	
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to verify response body and first name
	 * @since 02-06-2023
	 */

	@Then("User should verify the login response body firstName present as {string} and get the logtoken")
	public void user_should_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken(
			String expFirstName) {

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		String logToken = login_Output_Pojo.getData().getLogtoken();
		TC1_LoginStep.globalData.setLogToken(logToken);
		System.out.println(first_name);
		System.out.println(expFirstName);
		Assert.assertEquals("Verify first name", expFirstName, first_name);
	}

}
