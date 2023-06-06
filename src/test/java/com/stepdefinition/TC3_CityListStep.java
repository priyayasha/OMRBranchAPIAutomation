package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.base.UtilityClass;
import com.endpoints.Endpoints;
import com.globals.GlobalData;
import com.pojo.address.*;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author priya
 * @see purpose of this class is for CityList functionality
 * @since 02-06-2023
 */
public class TC3_CityListStep extends UtilityClass {
	static GlobalData globalData = new GlobalData();

	/**
 * 
 * @author priya
 * @see purpose of this method is to add headers
 * @since 02-06-2023
 */

	@Given("User add headers for city")
	public void user_add_headers_for_city() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

	}
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to send request with endpoint
	 * @since 02-06-2023
	 */

	
	@When("User send {string} request for CityList endpoint")
	public void user_send_request_for_city_list_endpoint(String reqType) {
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(TC1_LoginStep.globalData.getStateIdNum());
		addBody(cityList_Input_Pojo);
		Response response = addReqType("POST", Endpoints.CITYLIST);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		TC1_LoginStep.globalData.setStatusCode(statusCode);

	}
	
	/**
	 * 
	 * @author priya
	 * @see purpose of this method is to verify the city response message
	 * @since 02-06-2023
	 */

	@Then("User should verify the CityList response message matches {string} and save cityId")
	public void user_should_verify_the_city_list_response_message_matches_and_save_city_id(String expCityName) {

		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		ArrayList<CityList> cityList = cityList_Output_Pojo.getData();
		for (CityList data : cityList) {

			String name = data.getName();
			//System.out.println(name);

			if (name.equals(expCityName)) {
				int cityIdNum = data.getId();
				String cityId = String.valueOf(cityIdNum);
				TC1_LoginStep.globalData.setStateIdNum(cityId);

				Assert.assertEquals("Verify state Id", expCityName, name);
				break;

			}

		}

	}

}
