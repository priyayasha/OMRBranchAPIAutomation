package com.stepdefinition;

import java.util.ArrayList;
import org.junit.Assert;
import com.base.UtilityClass;
import com.endpoints.Endpoints;
import com.globals.GlobalData;
import com.pojo.address.StateList;
import com.pojo.address.StateList_Output_Pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * 
 * @author priya
 * @see purpose of this class is to verify state List functionality
 * @since 02-06-2023
 */

public class TC2_StateListStep extends UtilityClass {
	static GlobalData globalData = new GlobalData();
	Response response;
	//
	
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to add header
	 * @since 02-06-2023
	 */

	@Given("User add header for state")
	public void user_add_header_for_state() {
		addHeader("accept", "application/json");

	}
	
	
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to send request with endpoint
	 * @since 02-06-2023
	 */

	@When("User send {string} request for StateList endpoint")
	public void user_send_request_for_state_list_endpoint(String reqType) {
		response = addReqType(reqType, Endpoints.STATELIST);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatusCode(statusCode);
	}

	
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to verify the  state response message
	 * @since 02-06-2023
	 */

	@Then("User should verify the StateList response message matches {string} and save stateId")
	public void user_should_verify_the_state_list_response_message_matches_and_save_state_id(String expStateName) {

		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		ArrayList<StateList> stateList = stateList_Output_Pojo.getData();
		System.out.println("state ID");

		for (StateList data : stateList) {
			String name = data.getName();
			if (name.equals(expStateName)) {
				int stateIdNum = data.getId();
				String stateId = String.valueOf(stateIdNum);
				TC1_LoginStep.globalData.setStateIdNum(stateId);
				System.out.println("state ID"+stateId);
				
				System.out.println(TC1_LoginStep.globalData.getStateIdNum());
				 Assert.assertEquals("Verify state Id", expStateName, name);
				break;
			}
		}

	}

}
